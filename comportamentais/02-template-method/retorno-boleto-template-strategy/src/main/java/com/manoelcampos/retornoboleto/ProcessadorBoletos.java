package com.manoelcampos.retornoboleto;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Processa arquivos de retorno de boletos bancários utilizando a implementação de
 * alguma estratégia ({@link LeituraRetorno}).
 * Esta é uma classe que chamamos de Estrategista,
 * por poder utilizar diferentes estratégias de acordo com as necessidades,
 * podendo mudar a estratégia a ser utilizada até em tempo de execução.
 *
 * @author Manoel Campos da Silva Filho
 */
public class ProcessadorBoletos {
    private LeituraRetorno leituraRetorno;

    /**
     * Instancia a classe estrategista, já indicando
     * @param leituraRetorno
     */
    public ProcessadorBoletos(final LeituraRetorno leituraRetorno){
        this.leituraRetorno = leituraRetorno;
    }

    /**
     * Realiza de fato o processamento de um dado arquivo de retorno de boleto bancário,
     * utilizando uma estratégia definida em {@link #leituraRetorno}.
     * Este método pode realizar diversas operações após a leitura do arquivo,
     * como gravar dados em um banco, enviar emails de notificação, etc.
     * Neste caso, por simplificação, estamos apenas imprimindo os dados no terminal.
     *
     * <p>Este é o nosso Método Modelo (Template Method), pois ele define um algoritmo
     * e um desses passos é implementado em uma outra classe. Tal passo é o processamento
     * de uma linha do arquivo, feita pelo método {@link LeituraRetorno#processarLinhaArquivo(String[])}.
     * Mas perceba que, como unimos o Strategy com o Template Method, a modelagem ficou diferente
     * do que é apresentado para o Template Method.
     * Tal método acima (que representa uma operação primitiva do Template Method)
     * foi implementado não em uma subclasse da classe onde o Método Modelo está (este método),
     * mas sim em um objeto separado que é usado por meio de composição.
     * </p>
     *
     * <p>Desta forma, este é um projeto que mostra como podemos adaptar padrões de acordo com
     * nossas necessidades.</p>
     *
     * @param caminhoArquivo Caminho (URI) do arquivo a ser lido
     */
    public final void processar(URI caminhoArquivo){
        System.out.println("Boletos");
        System.out.println("----------------------------------------------------------------------------------");
        // tag::processar[]
        final var listaBoletos = new ArrayList<Boleto>();
        try {
            var listaLinhas = Files.readAllLines(Paths.get(caminhoArquivo));
            for (String linha : listaLinhas) {
                String[] vetor = linha.split(";");
                final var boleto = leituraRetorno.processarLinhaArquivo(vetor);
                listaBoletos.add(boleto);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        // end::processar[]

        for (var boleto : listaBoletos) {
            System.out.println(boleto);
        }
    }


    /**
     * Altera a estratégia a ser utilizada para leitura de arquivos de retorno de boletos bancários.
     * @param leituraRetorno nova estratégia a ser utilizada
     */
    public void setLeituraRetorno(final LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
}
