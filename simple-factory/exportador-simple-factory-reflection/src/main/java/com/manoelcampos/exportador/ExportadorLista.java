package com.manoelcampos.exportador;

import java.util.List;

/**
 * @author Manoel Campos da Silva Filho
 * @param <T> Tipo dos objetos da lista a ser exportada
 */
public interface ExportadorLista<T> {
    String abrirTabela();
    String fecharTabela();

    String abrirLinha();
    String fecharLinha();
    String fecharLinhaTitulos();

    String abrirColuna(String valor);
    String fecharColuna();
    String exportar(List<T> lista);

    List<String> getNomesCampos();

    static ExportadorLista getInstance(){
        return getInstance("html");
    }

    static ExportadorLista getInstance(String extensaoArquivoExportacao){
        switch (extensaoArquivoExportacao){
            case "html": return new ExportadorListaHtml();
            case "md": return new ExportadorListaMarkdown();
            default: throw new UnsupportedOperationException("Formato de arquivo não suportado: " + extensaoArquivoExportacao);
        }
    }
}
