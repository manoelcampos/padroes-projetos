package com.manoelcampos.exportador;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * Classe abstrata que fornece uma implementação base para as subclasses
 * que definem formatos específicos de exportação de dados.
 *
 * @param <T> tipo de objetos da lista a ser exportada
 * @author Manoel Campos da Silva Filho
 */
public abstract class AbstractExportadorLista<T> implements ExportadorLista<T> {
    /**
     * Lista genérica de objetos a serem exportados para um formato definido pelas subclasses.
     * Observe que o tipo não é um coringa como ?, mas um tipo genérico T.
     * Desta forma, se passarmos uma lista de Produto e desejarmos acessar
     * métodos específicos de tal classe, poderemos fazer naturalmente.
     *
     * <p>Se tivermos uma lista coringa como {@code List<?>} e esta contiver uma lista
     * de produtos, pelo fato de ela não ter sido declarada de forma genérica com {@code List<T>},
     * acessar um método como getDescricao() que seja específico da classe Produto é bastante complicado
     * e sucetível a erros em tempo de execução.</p>
     */
    private List<T> lista;

    /**
     * Lista de colunas que foramarão a tabela a ser exportada.
     */
    private List<Coluna> colunas;

    /**
     * Instancia um exportador de uma determinada lista de objetos.
     *
     * @param lista Lista genérica de objetos a ser exportada.
     */
    public AbstractExportadorLista(final List<T> lista) {
        Objects.requireNonNull(lista, "A lista de objetos não pode ser nula");
        if (lista.isEmpty()) {
            throw new IllegalArgumentException("A lista fornecida está vazia");
        }

        this.lista = lista;
        this.colunas = geraListaColunas();
    }

    @Override
    public String exportar() {
        final StringBuilder sb = new StringBuilder();
        sb.append(abrirTabela());
        exportarTitulosColunas(sb);
        exportarLinhas(sb);

        sb.append(fecharTabela());
        return sb.toString();
    }

    /**
     * Descobre dinamicamente os nomes das colunas dos objetos contindos na {@link #lista}
     * a ser exportada, a partir dos atributos dos objetos da lista.
     * Em seguida, gera as colunas da tabela a partir destes atributos.
     * Diferentes objetos possuem atributos distintos.
     * Uma vez que podemos exportar listas de qualquer tipo de objetos,
     * o método utiliza o recurso de Reflection do Java
     * para descobrir quais são os atributos dos objetos da lista que deseja-se exportar.
     *
     * @return a lista de colunas da tabela
     */
    private List<Coluna> geraListaColunas() {
        /*
        Pega o primeiro objeto da lista para podermos descobrir o nome dos atributos dele.
        Se a lista estiver vazia, já será gerada uma exceção anteriormente.
        */
        final T objeto = lista.get(0);

        final List<Coluna> colunas = new ArrayList<>();

        //Obtém o nome dos campos (fields) declarados diretamente na classe do objeto.
        final Field[] campos = objeto.getClass().getDeclaredFields();
        for (Field campo : campos) {
            //Atributos estáticos não serão incluídos na tabela gerada
            if (!Modifier.isStatic(campo.getModifiers())) {
                colunas.add(newColuna(campo));
            }
        }

        return colunas;
    }

    /**
     * Gera o texto representando a linha de títulos de uma tabela
     * (em um formato definido pelas subclasses).
     *
     * <p><b>AVISO</b>: Observe que há código duplicado com o método
     * {@link #exportarDadosColunas(StringBuilder, Object)}.</p>
     *
     * @param sb {@link StringBuilder} onde o texto gerado será adicionado
     */
    private void exportarTitulosColunas(StringBuilder sb) {
        sb.append(abrirLinha());
        for (Coluna coluna : colunas) {
            sb.append(coluna.exportarCabecalho());
        }
        sb.append(fecharLinha())
                .append(fecharLinhaTitulos());
    }

    /**
     * Gera o texto representando todas as linhas de uma tabela (em um formato definido pelas subclasses)
     * contendo os dados dos objetos na {@link #lista}.
     *
     * @param sb {@link StringBuilder} onde o texto gerado será adicionado
     */
    private void exportarLinhas(StringBuilder sb) {
        for (Object objeto : lista) {
            exportarDadosColunas(sb, objeto);
        }
    }

    /**
     * Gera o texto representando uma única linha de uma tabela
     * (em um formato definido pelas subclasses) contendo os dados das colunas.
     * Tais dados são os valores dos atributo de um objeto da lista.
     *
     * <p><b>AVISO</b>: Observe que há código duplicado com o método
     * {@link #exportarTitulosColunas(StringBuilder)}.</p>
     *
     * @param objeto objeto de onde o valor de um determinado campo será obtido para exibição na coluna
     * @param sb     {@link StringBuilder} onde o texto gerado será adicionado
     * @param objeto
     */
    private void exportarDadosColunas(StringBuilder sb, Object objeto) {
        sb.append(abrirLinha());
        for (Coluna coluna : colunas) {
            sb.append(coluna.exportarDado(objeto));
        }
        sb.append(fecharLinha());
    }

    /**
     * Lista de colunas que permitem gerar código no formato específico da tabela.
     */
    public List<Coluna> getColunas() {
        return colunas;
    }

    @Override
    public void addColuna(Coluna<T> coluna) {
        colunas.add(coluna);
    }

    /**
     * Adiciona uma nova coluna para ser inserida na tabela, cujo valor a ser exibido será obtido
     * a partir de um campo (atributo) específico de um objeto.
     * <b>Este método representa a aplicação do padrão Factory Method,
     * uma vez que as subclasses é que vão decidir qual objeto criar.</b>
     *
     * <p>O método é protegido pois é usado apenas internamente para gerar colunas
     * baseadas nos atributos existentes dos objetos da lista sendo exportada.
     * Para adicionar colunas manualmente, veja o método {@link #newColuna(Function, String)}.</p>
     *
     * @param campo  campo de onde o dado a ser exibido na coluna será obtido
     * @return uma nova coluna para uma tabela
     */
    protected abstract Coluna newColuna(Field campo);
}
