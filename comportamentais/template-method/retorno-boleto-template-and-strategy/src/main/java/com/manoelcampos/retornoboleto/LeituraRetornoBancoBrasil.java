package com.manoelcampos.retornoboleto;

import java.time.LocalDate;

/**
 * @author Manoel Campos da Silva Filho
 */
 //tag::class-start[]
public class LeituraRetornoBancoBrasil implements LeituraRetorno {
    @Override
    public Boleto processarLinhaArquivo(String[] vetorLinhaArq) {
        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetorLinhaArq[0]));
        boleto.setCodBanco(vetorLinhaArq[1]);
        //end::class-start[]

        boleto.setDataVencimento(LocalDate.parse(vetorLinhaArq[2], FORMATO_DATA));
        boleto.setDataPagamento(LocalDate.parse(vetorLinhaArq[3], FORMATO_DATA).atTime(0, 0, 0));

        //tag::class-end[]
        boleto.setCpfCliente(vetorLinhaArq[4]);
        boleto.setValor(Double.parseDouble(vetorLinhaArq[5]));
        boleto.setMulta(Double.parseDouble(vetorLinhaArq[6]));
        boleto.setJuros(Double.parseDouble(vetorLinhaArq[7]));
        return boleto;
    }
}
//end::class-end[]
