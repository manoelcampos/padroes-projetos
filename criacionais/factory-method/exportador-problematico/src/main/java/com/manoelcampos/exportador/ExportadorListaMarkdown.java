package com.manoelcampos.exportador;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Exporta uma tabela de objetos para o formato Markdown.
 * @author Manoel Campos da Silva Filho
 */
public class ExportadorListaMarkdown<T> extends AbstractExportadorLista<T> {
    private static final String SEPARADOR_LN = "-";

    /**
     * Instancia um exportador de uma determinada lista de objetos para o formato Markdown.
     *
     * @param lista Lista genérica de objetos a ser exportada.
     */
    public ExportadorListaMarkdown(List<T> lista) {
        super(lista);
    }

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
        for (Coluna coluna : getColunas()) {
            String linha = stringRepeat(SEPARADOR_LN, coluna.getTitulo().length());
            sb.append(linha).append(ColunaMarkdown.SEPARADOR);
        }

        sb.append("\n");
        return sb.toString();
    }

    private String stringRepeat(String s, int repeticoes){
        return String.format("%0" + repeticoes + "d", 0).replace("0", s);
    }

    @Override
    public Coluna newColuna(Field campo) {
        return new ColunaMarkdown<>(campo);
    }

}
