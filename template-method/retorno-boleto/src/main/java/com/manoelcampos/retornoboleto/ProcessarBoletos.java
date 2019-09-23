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
public abstract class ProcessarBoletos {
    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public abstract Boleto processarLinhaArquivo(String[] vetor);

    public void processar(String nomeArquivo){
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
            String line;
            List<Boleto> boletos = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] vetor = line.split(";");
                Boleto boleto = processarLinhaArquivo(vetor);
                boletos.add(boleto);
                System.out.println(boleto);
            }
        }catch(IOException ex){
            throw new UncheckedIOException(ex);
        }
    }
}
