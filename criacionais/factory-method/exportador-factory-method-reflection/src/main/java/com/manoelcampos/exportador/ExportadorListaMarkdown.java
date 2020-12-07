package com.manoelcampos.exportador;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Function;

/**
 * Exporta uma tabela de objetos para o formato Markdown.
 *
 * <p>Observe que, como estamos usando o padrão Simple Factory para instanciar
 * objetos {@link ExportadorLista}, as classes concretas como esta são definidas com visibilidade "package",
 * não podendo ser acessadas fora do pacote.
 * Assim, não teremos como instanciar diretamente tais classes.
 * A Simple Factory faz isso pra nós.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
class ExportadorListaMarkdown<T> extends AbstractExportadorLista<T> {
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
    protected Coluna newColuna(Field campo) {
        return new ColunaMarkdown<>(campo);
    }

    @Override
    public Coluna<T> newColuna(Function<T, String> funcaoValorColuna, String titulo) {
        return new ColunaMarkdown<>(funcaoValorColuna, titulo);
    }

}
