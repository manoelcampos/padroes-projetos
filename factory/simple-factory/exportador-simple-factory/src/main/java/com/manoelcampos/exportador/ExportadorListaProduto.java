package com.manoelcampos.exportador;

import java.util.List;

/**
 * Define a interface para criação de classes que implementam
 * a exportação de uma lista de produtos para
 * formatos específicos como HTML, CSV, Markdown, etc.
 *
 * @author Manoel Campos da Silva Filho
 */
public interface ExportadorListaProduto {
    /**
     * Retorna o código HTML para abertura de uma tabela.
     * @return
     */
    String abrirTabela();

    /**
     * Retorna o código para fechamento de uma tabela em um formato de dados específico.
     * @return
     */
    String fecharTabela();

    /**
     * Retorna o código para abertura de uma linha da tabela em um formato de dados específico.
     * @return
     */
    String abrirLinha();

    /**
     * Retorna o código para fechamento de uma linha da tabela em um formato de dados específico.
     * @return
     */
    String fecharLinha();

    /**
     * Retorna o código para fechamento da linha de títulos de uma tabela em um formato de dados específico.
     * @return
     */
    String fecharLinhaTitulos();

    /**
     * Retorna o código para abertura de uma coluna de uma tabela em um formato de dados específico.
     * @param valor valor a ser exibido na coluna
     * @return
     */
    String abrirColuna(String valor);

    /**
     * Retorna o código para fechamento de uma coluna de uma tabela em um formato de dados específico.
     * @return
     */
    String fecharColuna();

    /**
     * Inicia a exportação da lista de produtos para um formato específico.
     * @param produtos Lista de produtos a ser exportada
     * @return String contendo o conteúdo da lista de produtos em um formato específico
     */
    String exportar(List<Produto> produtos);

    /**
     * Cria uma instância de uma classe
     * que realiza a exportação de dados para um formato padrão.
     * Neste caso, tal formato padrão é HTML.
     * @return
     */
    static ExportadorListaProduto newInstance(){
        return newInstance("html");
    }

    /**
     * Cria uma instância de uma classe
     * que realiza a exportação de dados para um formato definido.
     * @param extensaoArquivoExportacao extensão de arquivo que indica o formato para converter os dados,
     *                                  como html, csv, md (markdown), etc.
     * @return
     */
    static ExportadorListaProduto newInstance(String extensaoArquivoExportacao){
        switch (extensaoArquivoExportacao){
            case "html": return new ExportadorListaProdutoHtml();
            case "md": return new ExportadorListaProdutoMarkdown();
            default: throw new UnsupportedOperationException("Formato de arquivo não suportado: " + extensaoArquivoExportacao);
        }
    }
}
