package com.manoelcampos.retornoboleto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Define um contrato para implementação de estratégias
 * de leitura de arquivos de retorno de bancos brasileiros (como Banco do Brasil e Bradesco).
 *
 * @author Manoel Campos da Silva Filho
 */
public interface LeituraRetorno {
    DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    List<ProcessaCampoArquivo<?>> getProcessadoresCampos();    
    
    default List<Boleto> lerArquivo(String nomeArquivo) {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
            String line;
            List<Boleto> boletos = new ArrayList<>();
            while((line = reader.readLine()) != null){
                String[] vetor = line.split(";");
                Boleto boleto = new Boleto();
                for (int i = 0; i < getProcessadoresCampos().size(); i++) {
                    setCampoBoleto(i, boleto, vetor[i]);
                }
                boletos.add(boleto);
            }

            return boletos;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private void setCampoBoleto(int idxCampo, Boleto boleto, String valor) {
        ProcessaCampoArquivo processador = getProcessadoresCampos().get(idxCampo);
        try {
            Field field = boleto.getClass().getDeclaredField(processador.getCampo());
            field.setAccessible(true);
            field.set(boleto, processador.converter(valor));
        } catch (NoSuchFieldException | SecurityException |  IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }

    default int toInteger(String valor){
        return Integer.parseInt(valor);
    }
    
    default double toDouble(String valor){
        return Double.parseDouble(valor);
    }

    default LocalDate toLocalDate(String valor){
        return LocalDate.parse(valor, FORMATO_DATA);
    }
    
    default LocalDateTime toLocalDateTimeEmptyTime(String valor){
        return LocalDate.parse(valor, FORMATO_DATA).atTime(0, 0, 0);
    }
    
    default LocalDateTime toLocalDateTime(String valor){
        return LocalDateTime.parse(valor, FORMATO_DATA);
    }
    
}
