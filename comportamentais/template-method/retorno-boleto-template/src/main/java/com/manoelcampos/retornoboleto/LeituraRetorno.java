package com.manoelcampos.retornoboleto;

import java.time.format.DateTimeFormatter;

/**
 * Define uma interface com um contrato para implementar a operação de processar uma linha
 * de um arquivo de retorno de boletos (como Banco do Brasil e Bradesco)
 * usando o padrão Template Method.
 * As classe que implementarem tal interface devem definir um método para implementar
 * apenas o processamento de uma linha individual
 * do arquivo de retorno, no lugar de processar todas as linhas do arquivo inteiro
 * em um único método.
 *
 * <p>O método aqui definido representa uma operação primitiva do padrão Template Method.
 * No nosso caso, temos apenas uma operação, o processamento de uma linha
 * de um arquivo de retorno.
 * </p>
 *
 * <p>Anteriormente, utilizando o padrão Strategy, tal interface
 * representa a implementação de uma estratégia
 * para fazer a leitura completa de um arquivo de retorno de boleto.
 * Agora ela representa apenas uma parte deste algoritimo,
 * que é responsável por processar uma única linha do arquivo por vez</p>
 *
 * @author Manoel Campos da Silva Filho
 * @see ProcessarBoletos
 */
public interface LeituraRetorno {
    DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * Recebe um vetor com os dados lidos de uma linha de um arquivo
     * de retorno de boleto
     * @param vetor vetor contendo os dados de uma linha lida do arquivo,
     *              onde cada posição representa uma coluna do boleto
     * @return um objeto {@link Boleto} com os dados processados da linha do arquivo
     */
    Boleto processarLinhaArquivo(String[] vetor);
}
