package com.manoelcampos.retornoboleto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Manoel Campos da Silva Filho
 */
//tag::class-start[] 
public class ProcessadorBoletos {
    private Function<String[], Boleto> processarLinhaArquivo;
    
    public ProcessadorBoletos(
            Function<String[], Boleto> processarLinhaArquivo){
        this.processarLinhaArquivo = processarLinhaArquivo;
    }

    public List<Boleto> processar(String nomeArquivo){
        try {
            BufferedReader reader = 
                Files.newBufferedReader(Paths.get(nomeArquivo));
            String line;
            List<Boleto> boletos = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] vetor = line.split(";");
                Boleto boleto = processarLinhaArquivo.apply(vetor);
                boletos.add(boleto);
                System.out.println(boleto);
            }
            return boletos;
        }catch(IOException ex){
            throw new UncheckedIOException(ex);
        }
    }
    //end::class-start[] 

    public void setProcessarLinhaArquivo(Function<String[], Boleto> processarLinhaArquivo) {
        this.processarLinhaArquivo = processarLinhaArquivo;
    }
    
    //tag::class-end[] 
}
//end::class-end[] 
