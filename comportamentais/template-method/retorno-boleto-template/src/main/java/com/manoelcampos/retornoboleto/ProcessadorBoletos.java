package com.manoelcampos.retornoboleto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstrata que implementa o padrão Template Method
 * para a leitura de arquivos de retorno de boletos bancários.
 * @author Manoel Campos da Silva Filho
 */
// tag::class-start[]
public abstract class ProcessadorBoletos {
// end::class-start[]

    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * Processa um arquivo de retorno de boleto bancário
     * e imprime o resultado no terminal (mas
     * poderia fazer qualquer outra coisa como gravar em um banco
     * de dados, gerar um PDF, enviar um email com confirmação
     * de pagamento do boleto para o cliente, etc).
     *
     * <p>Este é o chamado Template Method,
     * que representa um algoritmo, cujo um ou mais passos
     * são métodos abstratos definidos nas subclasses.</p>
     *
     * @param nomeArquivo Nome do arquivo a ser processado
     */
    // tag::template-method[]
    public final List<Boleto> processar(String nomeArquivo){
        try {
            BufferedReader reader = 
                Files.newBufferedReader(Paths.get(nomeArquivo));
            String line;
            List<Boleto> boletos = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] vetor = line.split(";");
                Boleto boleto = processarLinhaArquivo(vetor);
                boletos.add(boleto);
                System.out.println(boleto);
            }

            return boletos;
        }catch(IOException ex){
            throw new UncheckedIOException(ex);
        }
    }

    // end::template-method[]

    /**
     * Recebe um vetor com os dados lidos de uma linha de um arquivo
     * de retorno de boleto
     * @param vetorLinhaArq vetor contendo os dados de uma linha lida do arquivo,
     *              onde cada posição representa uma coluna do boleto
     * @return um objeto {@link Boleto} com os dados processados da linha do arquivo
     */
    // tag::primitive-operation[]
    protected abstract Boleto processarLinhaArquivo(String[] vetorLinhaArq);
    // end::primitive-operation[]

// tag::class-end[]
}
// end::class-end[]
