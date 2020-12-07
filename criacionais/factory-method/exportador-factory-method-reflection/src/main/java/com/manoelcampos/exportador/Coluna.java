package com.manoelcampos.exportador;

/**
 * Interface a ser implementada para representar
 * uma coluna de uma tabela em um determinado formato,
 * como HTML, CSV, XML, AsciiDoc, Markdown, etc.
 *
 * @author Manoel Campos da Silva Filho
 * @param <T> tipo de objetos da lista a ser exportada
 */
public interface Coluna<T> {
    /**
     * Obtém o título a ser exibido na coluna da tabela.
     * Por padrão, o título é o nome do atributo dos objetos contidos na
     * lista de dados sendo exportados.
     * @return
     *
     * @see ExportadorLista
     */
    String getTitulo();

    /**
     * Altera o título a ser exibido na coluna da tabela.
     * Por padrão, o título é o nome do atributo dos objetos contidos na
     * lista de dados sendo exportados.
     * @param titulo título para a coluna
     * @return
     *
     * @see ExportadorLista
     */
    void setTitulo(String titulo);

    /**
     * Retorna o código para abertura de uma coluna de uma tabela em um formato de dados específico.
     * @return
     */
    String abrir();

    /**
     * Retorna o código para fechamento de uma coluna de uma tabela em um formato de dados específico.
     * @return
     */
    String fechar();

    /**
     * Gera o código para representar o título da coluna em um formato específico.
     * @return
     */
    String exportarCabecalho();

    /**
     * Gera o código para representar a coluna em um formato específico, contendo
     * o dado armazenado em um atributo de um objeto
     * da lista a ser exportada.
     *
     * @param objeto objeto de onde o valor de um determinado campo será obtido para exibição na coluna
     * @return
     */
    String exportarDado(T objeto);
}
