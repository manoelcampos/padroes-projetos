package com.manoelcampos.exportador;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Manoel Campos da Silva Filho
 */
public abstract class AbstractExportadorLista<T> implements ExportadorLista<T> {
    private List<T> lista;
    private List<String> nomesCampos;

    @Override
    public String exportar(List<T> lista) {
        Objects.requireNonNull(lista);
        if(lista.isEmpty()){
            throw new IllegalArgumentException("A lista fornecida está vazia");
        }

        this.lista = lista;
        this.nomesCampos = gerarTitulosColunas();

        final StringBuilder sb = new StringBuilder();
        sb.append(abrirTabela());

        gerarColunasLinha(sb, nomesCampos);
        sb.append(fecharLinhaTitulos());
        gerarLinhasObjetos(sb);

        sb.append(fecharTabela());
        return sb.toString();
    }

    private List<String> gerarTitulosColunas() {
        T objeto = lista.get(0);
        List<String> titulosColunas = new ArrayList<>();
        Field[] campos = objeto.getClass().getDeclaredFields();
        for (Field campo : campos) {
            titulosColunas.add(campo.getName());
        }

        return titulosColunas;
    }

    private void gerarLinhasObjetos(StringBuilder sb) {
        for (T objeto : lista) {
            gerarLinhaObjeto(sb, objeto);
        }
    }

    private void gerarLinhaObjeto(StringBuilder sb, T objeto) {
        List<String> valoresCamposObjeto = new ArrayList<>();
        for (String campo : nomesCampos) {
            String valorCampo = obtemValorCampoObjeto(objeto, campo);
            valoresCamposObjeto.add(String.valueOf(String.valueOf(valorCampo)));
        }
        gerarColunasLinha(sb, valoresCamposObjeto);
    }

    private String obtemValorCampoObjeto(T objeto, String nomeCampo) {
        Object valorCampo;
        try {
            Field campo = objeto.getClass().getDeclaredField(nomeCampo);
            campo.setAccessible(true);
            valorCampo = campo.get(objeto);

            return valorCampo == null ? "" : String.valueOf(valorCampo);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    private void gerarColunasLinha(StringBuilder sb, List<String> valores) {
        sb.append(abrirLinha());
        for (String valor : valores) {
            sb.append(abrirColuna(valor))
              .append(fecharColuna());
        }
        sb.append(fecharLinha());
    }

    @Override
    public List<String> getNomesCampos() {
        return nomesCampos;
    }
}
