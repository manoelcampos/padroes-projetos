package com.manoelcampos.retornoboleto;

import java.io.UncheckedIOException;
import java.util.List;

/**
 * @author Manoel Campos da Silva Filho
 */
public interface LeituraRetorno {
    List<Boleto> lerArquivo(String nomeArquivo) ;
}
