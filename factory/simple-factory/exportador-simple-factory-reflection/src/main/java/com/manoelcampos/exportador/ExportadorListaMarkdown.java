package com.manoelcampos.exportador;

/**
 * @author Manoel Campos da Silva Filho
 */
public class ExportadorListaMarkdown extends AbstractExportadorLista {
    private static final String SEPARADOR_LN = "-";
    private static final String SEPARADOR_COL = "|";

    @Override
    public String abrirTabela() {
        return "";
    }

    @Override
    public String fecharTabela() {
        return "\n";
    }

    @Override
    public String abrirLinha() {
        return "";
    }

    @Override
    public String fecharLinha() {
        return "\n";
    }

    @Override
    public String fecharLinhaTitulos() {
        StringBuilder sb = new StringBuilder();
        for (String coluna : getNomesCampos()) {
            String linha = stringRepeat(SEPARADOR_LN, coluna.length());
            sb.append(linha).append(SEPARADOR_COL);
        }

        sb.append("\n");
        return sb.toString();
    }

    private String stringRepeat(String s, int repeticoes){
        return String.format("%0" + repeticoes + "d", 0).replace("0", s);
    }

    @Override
    public String abrirColuna(String valor) {
        return valor;
    }

    @Override
    public String fecharColuna() {
        return " " + SEPARADOR_COL;
    }
}
