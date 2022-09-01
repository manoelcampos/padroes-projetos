package com.manoelcampos.retornoboleto;

import java.time.format.DateTimeFormatter;

/**
 * Define um contrato para implementação de estratégias
 * de processamento de cada linha de arquivos de retorno de bancos brasileiros
 * (como Banco do Brasil e Bradesco).
 *
 * @author Manoel Campos da Silva Filho
 */
public interface LeituraRetorno {
    DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


    /**
     * Recebe um vetor com os dados lidos de uma linha de um arquivo
     * de retorno de boleto
     * @param vetorLinhaArq vetor contendo os dados de uma linha lida do arquivo,
     *              onde cada posição representa uma coluna do boleto
     * @return um objeto {@link Boleto} com os dados processados da linha do arquivo
     */
    Boleto processarLinhaArquivo(String[] vetorLinhaArq);
}
