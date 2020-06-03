package com.manoelcampos.retornoboleto;

import java.util.List;
import java.util.function.Function;


/**
 * Realiza a leitura de arquivos de retorno de boletos bancários no formato do Bradesco.
 * Esta classe usa o padrão Strategy, representando a implementação da estratégia {@link LeituraRetorno}.
 *
 * @author Manoel Campos da Silva Filho
 */
public class LeituraRetornoBradesco implements LeituraRetorno {
    private final List<ProcessaCampoArquivo<?>> processadoresCampos = List.of(
        new ProcessaCampoArquivo<>("id", this::toInteger),                   
        new ProcessaCampoArquivo<>("codBanco", Function.identity()),
        new ProcessaCampoArquivo<>("agencia", Function.identity()),
        new ProcessaCampoArquivo<>("contaBancaria", Function.identity()),
        new ProcessaCampoArquivo<>("dataVencimento", this::toLocalDate),
        new ProcessaCampoArquivo<>("dataPagamento", this::toLocalDateTime),
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
