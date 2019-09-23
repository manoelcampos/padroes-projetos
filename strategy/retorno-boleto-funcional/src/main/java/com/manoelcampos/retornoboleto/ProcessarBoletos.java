package com.manoelcampos.retornoboleto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Manoel Campos da Silva Filho
 */
public class ProcessarBoletos {

    private Function<String, List<Boleto>> lerArquivo;

    public ProcessarBoletos(Function<String, List<Boleto>> lerArquivo){
        this.lerArquivo = lerArquivo;
    }
    
    public void processar(String nomeArquivo){
        List<Boleto> boletos = lerArquivo.apply(nomeArquivo);
        for (Boleto boleto : boletos) {
            System.out.println(boleto);
        }
    }

}
