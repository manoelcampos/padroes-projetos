package com.manoelcampos.exportador;

/**
 * @author Manoel Campos da Silva Filho
 */
public class ExportadorListaHtml<T> extends AbstractExportadorLista<T> {
    @Override
    public String abrirTabela() {
        return "<table>\n";
    }

    @Override
    public String fecharTabela() {
        return "</table>\n";
    }

    @Override
    public String abrirLinha() {
        return "  <tr>";
    }

    @Override
    public String fecharLinha() {
        return "</tr>\n";
    }

    @Override
    public String fecharLinhaTitulos() {
        return "";
    }

    @Override
    public String abrirColuna(String valor) {
        return "<td>" + valor;
    }

    @Override
    public String fecharColuna() {
        return "</td>";
    }
}
