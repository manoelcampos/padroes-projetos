package com.manoelcampos.retornoboleto;

import java.time.format.DateTimeFormatter;

/**
 * Interface com operação para processar uma linha
 * de um arquivo de retorno de boletos (como Banco do Brasil e Bradesco).
 * O projeto usa o padrão Template Method
 * para implementar apenas o processamento de uma linha individual
 * do arquivo de retorno, no lugar de processar todas as linhas do arquivo inteiro
 * em um único método.
 *
 * @author Manoel Campos da Silva Filho
 */
public interface LeituraRetorno {
    DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    Boleto processarLinhaArquivo(String[] vetor);
}
