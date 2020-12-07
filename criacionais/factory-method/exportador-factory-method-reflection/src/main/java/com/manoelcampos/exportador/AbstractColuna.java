package com.manoelcampos.exportador;

import java.lang.reflect.Field;
import java.util.function.Function;

/**
 * @param <T> tipo de objetos da lista a ser exportada
 * @author Manoel Campos da Silva Filho
 */
public abstract class AbstractColuna<T> implements Coluna<T> {

    /**
     * Representa um determinado campo (atributo) de um objeto.
     * A classe {@link Field} faz parte da API de Reflection
     * fornecida pela linguagem Java.
     * Reflection é um recurso para permitir acesso dinâmico
     * a informações de classes e objetos.
     * Por meio da classe Field, podemos obter o nome
     * de um campo, o valor que um determinado objeto armazena
     * para tal campo, o tipo do campo, etc.
     *
     * <p>Tal atributo só é usado se o construtor {@link #AbstractColuna(Field)}
     * for chamado. Caso contrário, o valor a ser exibido para a coluna é obtido
     * de {@link #funcaoValorColuna}.</p>
     */
    private Field campo;

    /**
     * Título a ser exibido na coluna.
     * Por padrão, este é o nome do campo.
     */
    private String titulo;

    /**
     * Função ({@link Function}) que recebe um objeto
     * da lista a ser exportada e retorna uma String
     * que representa o conteúdo a ser exibido para a coluna.
     * Tal atributo só é usado se o construtor {@link #AbstractColuna(Function, String)}
     * for chamado. Caso contrário, o valor a ser exibido para a coluna é obtido
     * de {@link #campo}.
     */
    private Function<T, String> funcaoValorColuna;

    /**
     * Instancia uma coluna para uma tabela, cujo valor a ser exibido será obtido
     * a partir de um campo (atributo) específico de um objeto.
     * <p>Este construtor é protegido pois é usado apenas internamente.</p>
     *
     * @param campo  campo (atributo) do objeto a ser obtido o valor
     *
     * @see #AbstractColuna(Function, String)
     */
    protected AbstractColuna(Field campo) {
        this(campo.getName());
        this.campo = campo;

        /*Como estamos acessando um campo (que possivelmente é privado) via Reflection e não
         * por meio de um getter, precisamos chamar o método setAcessible para quebrar o bloqueio
         * ao campo privado e permitir o acesso.*/
        this.campo.setAccessible(true);
    }

    /**
     * Instancia uma coluna para uma tabela, cujo valor a ser exibido será obtido
     * a partir de uma função que recebe um objeto da lista a ser exportada e retorna
     * uma String com dados obtidos de qualquer atributo deste objeto.
     *
     * <p>Este construtor é definido como protegido para evitar que ele seja
     * chamado diretamente, uma vez que classes como {@link ExportadorListaHtml}
     * implementam o Factory Method {@link ExportadorListaHtml#newColuna(Function, String)},
     * usado para criar instâncias de subclasses específicas quando estiver sendo
     * gerada uma tabela em um determinado formato.</p>
     *
     * @param funcaoValorColuna uma função ({@link Function}) que recebe um objeto
     *                          da lista a ser exportada e retorna uma String
     *                          que representa o conteúdo a ser exibido para a coluna
     * @param titulo título a ser exibido na coluna
     *
     * @see #AbstractColuna(Field)
     */
    protected AbstractColuna(Function<T, String> funcaoValorColuna, String titulo) {
        this(titulo);
        this.funcaoValorColuna = funcaoValorColuna;
    }

    /**
     * Construtor usado internamente para inicializar alguns atributos e evitar duplicação
     * de código entre os outros construtores
     * @param titulo título a ser exibido na coluna
     *
     * @see #AbstractColuna(Field)
     * @see #AbstractColuna(Function, String)
     */
    private AbstractColuna(String titulo) {
        setTitulo(titulo);
    }

    /**
     * Obtém o valor de um determinado campo (atributo) de um objeto da lista
     * de objetos a serem exportados na tabela.
     *
     * @param objeto objeto de onde o valor de um determinado campo será obtido para exibição na coluna
     * @return o valor do campo como String ou vazio se o campo for null
     */
    private String getValor(T objeto) {
        /* Se o valor da coluna foi definido para ser obtido a partir de uma
         * função passada em um dos construtores, chama tal função. */
        if(funcaoValorColuna != null){
            return funcaoValorColuna.apply(objeto);
        }

        /* Caso o valor foi definido para ser obtido a partir de um
         * atributo de um objeto da lista a ser exportada,
         * obtém o valor de tal atributo representado pela variável "campo".
         */
        try {
            final Object valorCampo = campo.get(objeto);
            return valorCampo == null ? "" : String.valueOf(valorCampo);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public final void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public final String exportarCabecalho() {
        return abrir() + getTitulo() + fechar();
    }

    @Override
    public final String exportarDado(T objeto) {
        return abrir() + getValor(objeto) + fechar();
    }
}
