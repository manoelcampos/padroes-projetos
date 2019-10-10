package com.manoelcampos.exportador;

import java.util.List;

/**
 * @author Manoel Campos da Silva Filho
 */
public interface ExportadorListaProduto {
    String abrirTabela();
    String fecharTabela();

    String abrirLinha();
    String fecharLinha();
    String fecharLinhaTitulos();

    String abrirColuna(String valor);
    String fecharColuna();
    String exportar(List<Produto> produtos);

    static ExportadorListaProduto getInstance(){
        return getInstance("html");
    }

    static ExportadorListaProduto getInstance(String extensaoArquivoExportacao){
        switch (extensaoArquivoExportacao){
            case "html": return new ExportadorListaProdutoHtml();
            case "md": return new ExportadorListaProdutoMarkdown();
            default: throw new UnsupportedOperationException("Formato de arquivo não suportado: " + extensaoArquivoExportacao);
        }
    }
}
