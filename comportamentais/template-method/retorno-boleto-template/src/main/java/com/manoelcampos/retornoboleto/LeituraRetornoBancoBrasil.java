package com.manoelcampos.retornoboleto;

import java.time.LocalDate;

/**
 * Classe que compõe a implementação do padrão Template Method,
 * contendo método que representa um passo do template
 * na superclasse.
 *
 * @author Manoel Campos da Silva Filho
 */
// tag::class-start[]
public class LeituraRetornoBancoBrasil extends ProcessadorBoletos {
// end::class-start[]

    // tag::primitive-operation-start[]
    @Override
    protected Boleto processarLinhaArquivo(String[] linhaArquivo) {
        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(linhaArquivo[0]));
        boleto.setCodBanco(linhaArquivo[1]);
        // end::primitive-operation-start[]

        boleto.setDataVencimento(
            LocalDate.parse(linhaArquivo[2], FORMATO_DATA));
        boleto.setDataPagamento(
            LocalDate.parse(linhaArquivo[3], FORMATO_DATA).atTime(0, 0, 0));

        // tag::primitive-operation-end[]
        boleto.setCpfCliente(linhaArquivo[4]);
        boleto.setValor(Double.parseDouble(linhaArquivo[5]));
        boleto.setMulta(Double.parseDouble(linhaArquivo[6]));
        boleto.setJuros(Double.parseDouble(linhaArquivo[7]));
        return boleto;
    }
    // end::primitive-operation-end[]
// tag::class-end[]
}
// end::class-end[]
