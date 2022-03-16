package com.manoelcampos.retornoboleto;

import java.net.URI;
import java.time.format.DateTimeFormatter;
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

    /**
     * Lê um arquivo de retorno de boleto bancário.
     * @param caminhoArquivo Caminho (URI) do arquivo a ser lido
     */
    List<Boleto> lerArquivo(URI caminhoArquivo);
}
