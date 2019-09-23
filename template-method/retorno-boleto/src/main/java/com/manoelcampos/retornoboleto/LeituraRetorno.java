package com.manoelcampos.retornoboleto;

import java.time.LocalDate;
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
 * <p>O método aqui definido representam uma operação primitiva do padrão Template Method.
 * No nosso caso, temos apenas uma operação, o processamento de uma linha
 * de um arquivo de retorno.
 * </p>
 *
 * @author Manoel Campos da Silva Filho
 */
public interface LeituraRetorno {

}
