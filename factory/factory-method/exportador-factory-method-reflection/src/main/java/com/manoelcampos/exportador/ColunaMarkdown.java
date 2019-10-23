package com.manoelcampos.exportador;

import java.lang.reflect.Field;
import java.util.function.Function;

/**
 * Gera dados de um atributo de um objeto como uma coluna em uma tabela Markdown.
 * @param <T> tipo de objetos da lista a ser exportada
 * @author Manoel Campos da Silva Filho
 */
public class ColunaMarkdown<T> extends AbstractColunaTabela<T> {
    public static final String SEPARADOR = "|";

    /**
     * Instancia uma coluna para uma tabela Markdown, cujo valor a ser exibido será obtido
     * a partir de um campo (atributo) específico de um objeto.
     *
     * @param objeto objeto de onde o valor de um determinado campo será obtido
     * @param campo  campo (atributo) do objeto a ser obtido o valor
     * @return o valor do campo como String ou vazio se o campo for null
     */
    protected ColunaMarkdown(T objeto, Field campo) {
        super(objeto, campo);
    }

    /**
     * Instancia uma coluna para uma tabela Markdown, cujo valor a ser exibido será obtido
     * a partir de uma função que recebe um objeto da lista a ser exportada e retorna
     * uma String com dados obtidos de qualquer atributo deste objeto.
     *
     * @param objeto            objeto de onde o valor de um determinado campo será obtido
     * @param funcaoValorColuna uma função ({@link Function}) que recebe um objeto
     *                          da lista a ser exportada e retorna uma String
     *                          que representa o conteúdo a ser exibido para a coluna
     * @param titulo título a ser exibido na coluna
     */
    protected ColunaMarkdown(T objeto, Function<T, String> funcaoValorColuna, String titulo) {
        super(objeto, funcaoValorColuna, titulo);
    }

    @Override
    public String abrir() {
        return "";
    }

    @Override
    public String fechar() {
        return " " + SEPARADOR;
    }

}