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
import java.util.function.Function;

/**
 * Realiza a leitura de arquivos de retorno de boletos bancários no formato do Banco do Brasil.
 * Esta classe usa o padrão Strategy, representando a implementação da estratégia {@link LeituraRetorno}.
 *
 * @author Manoel Campos da Silva Filho
 */
public class LeituraRetornoBancoBrasil implements LeituraRetorno {
    private final List<ProcessaCampoArquivo<?>> processadoresCampos = List.of(
        new ProcessaCampoArquivo<>("id", this::toInteger),                   
        new ProcessaCampoArquivo<>("codBanco", Function.identity()),                   
        new ProcessaCampoArquivo<>("dataVencimento", this::toLocalDate),
        new ProcessaCampoArquivo<>("dataPagamento", this::toLocalDateTimeEmptyTime),
        new ProcessaCampoArquivo<>("cpfCliente", Function.identity()),                   
        new ProcessaCampoArquivo<>("valor", this::toDouble),
        new ProcessaCampoArquivo<>("multa", this::toDouble),
        new ProcessaCampoArquivo<>("juros", this::toDouble)
    );


    @Override
    public List<ProcessaCampoArquivo<?>> getProcessadoresCampos() {
        return processadoresCampos;
    }
}
