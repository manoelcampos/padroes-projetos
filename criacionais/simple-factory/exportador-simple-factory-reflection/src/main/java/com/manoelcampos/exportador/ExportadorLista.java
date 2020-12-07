package com.manoelcampos.exportador;

import java.util.List;

/**
 * Define uma interface para criação de classes que implementam
 * a exportação de uma lista de objetos para
 * formatos específicos como HTML, CSV, Markdown, etc.
 *
 * <p>Esta interface e suas implementações não fazem um uso
 * mais abrangente do recurso de Generics do Java
 * apenas para tornar a implementação mais simples,
 * pois não é objetivo explicar os detalhes de Generics.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
public interface ExportadorLista {
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
     * Inicia a exportação da lista de objetos para um formato específico.
     *
     * @param lista Lista de objetos a ser exportada.
     */
    String exportar(List<?> lista);

    /**
     * Obtém uma lista com o nome dos atributos dos objetos contidos nela.
     * Os nomes dos atributos são então usados como títulos das colunas na tabela
     * gerado no formado especificado ao criar uma instância de {@link ExportadorLista}.
     *
     * @return
     * @see #newInstance()
     * @see #newInstance(String)
     */
    List<String> getNomesCampos();

    /**
     * Cria uma instância de uma classe
     * que realiza a exportação de dados para um formato padrão.
     * Neste caso, tal formato padrão é HTML.
     * @return
     */
    static ExportadorLista newInstance(){
        return newInstance("html");
    }

    /**
     * Cria uma instância de uma classe
     * que realiza a exportação de dados para um formato definido.
     * @param extensaoArquivoExportacao extensão de arquivo que indica o formato para converter os dados,
     *                                  como html, csv, md (markdown), etc.
     * @return
     */
    static ExportadorLista newInstance(String extensaoArquivoExportacao){
        switch (extensaoArquivoExportacao){
            case "html": return new ExportadorListaHtml();
            case "md": return new ExportadorListaMarkdown();
            default: throw new UnsupportedOperationException("Formato de arquivo não suportado: " + extensaoArquivoExportacao);
        }
    }}
