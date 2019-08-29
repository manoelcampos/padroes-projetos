package com.manoelcampos.retornoboleto;

import java.io.UncheckedIOException;
import java.util.List;

/**
 * @author Manoel Campos da Silva Filho
 */
public class LeituraRetornoBradesco implements LeituraRetorno {
    @Override
    public List<Boleto> lerArquivo(String nomeArquivo) {
        throw new UnsupportedOperationException("Método não implementado ainda. Apague esta linha quando for implementá-lo.");
    }
}
