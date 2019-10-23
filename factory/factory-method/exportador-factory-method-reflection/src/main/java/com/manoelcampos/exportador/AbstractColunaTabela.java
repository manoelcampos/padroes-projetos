package com.manoelcampos.exportador;

/**
 * @author Manoel Campos da Silva Filho
 */
public class AbstractColunaTabela implements ColunaTabela {
    @Override
    public String getTitulo() {
        return null;
    }

    @Override
    public String abrirColuna(String valor) {
        return null;
    }

    @Override
    public String fecharColuna() {
        return null;
    }
}
