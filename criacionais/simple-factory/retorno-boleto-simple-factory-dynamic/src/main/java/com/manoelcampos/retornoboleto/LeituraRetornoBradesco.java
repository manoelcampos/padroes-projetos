package com.manoelcampos.retornoboleto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Processa linhas de arquivos de retorno do Bradesco.
 *
 * <p>Observe que, como estamos usando o padrão Simple Factory para instanciar
 * objetos {@link LeituraRetorno}, as classes concretas como esta são definidas com visibilidade "package",
 * não podendo ser acessadas fora do pacote.
 * Assim, não teremos como instanciar diretamente tais classes.
 * A Simple Factory faz isso pra nós.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
class LeituraRetornoBradesco implements LeituraRetorno {
    @Override
    public Boleto processarLinhaArquivo(String[] vetor) {
        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetor[0]));
        boleto.setCodBanco(vetor[1]);
        boleto.setAgencia(vetor[2]);
        boleto.setContaBancaria(vetor[3]);

        boleto.setDataVencimento(LocalDate.parse(vetor[4], LeituraRetorno.FORMATO_DATA));
        boleto.setDataPagamento(LocalDateTime.parse(vetor[5], LeituraRetorno.FORMATO_DATA_HORA));

        boleto.setCpfCliente(vetor[6]);
        boleto.setValor(Double.parseDouble(vetor[7]));
        boleto.setMulta(Double.parseDouble(vetor[8]));
        boleto.setJuros(Double.parseDouble(vetor[9]));
        return boleto;
    }
}
