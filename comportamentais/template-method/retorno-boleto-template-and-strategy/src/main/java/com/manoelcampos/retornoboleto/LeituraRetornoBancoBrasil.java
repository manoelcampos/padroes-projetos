package com.manoelcampos.retornoboleto;

import java.time.LocalDate;

/**
 * @author Manoel Campos da Silva Filho
 */
 //tag::class-start[]
public class LeituraRetornoBancoBrasil implements LeituraRetorno {
    @Override
    public Boleto processarLinhaArquivo(String[] linhaArquivo) {
        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(linhaArquivo[0]));
        boleto.setCodBanco(linhaArquivo[1]);
        //end::class-start[]

        boleto.setDataVencimento(LocalDate.parse(linhaArquivo[2], FORMATO_DATA));
        boleto.setDataPagamento(LocalDate.parse(linhaArquivo[3], FORMATO_DATA).atTime(0, 0, 0));

        //tag::class-end[]
        boleto.setCpfCliente(linhaArquivo[4]);
        boleto.setValor(Double.parseDouble(linhaArquivo[5]));
        boleto.setMulta(Double.parseDouble(linhaArquivo[6]));
        boleto.setJuros(Double.parseDouble(linhaArquivo[7]));
        return boleto;
    }
}
//end::class-end[]
