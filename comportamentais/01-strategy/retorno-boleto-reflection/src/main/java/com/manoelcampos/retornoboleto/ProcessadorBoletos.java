package com.manoelcampos.retornoboleto;

import java.net.URI;
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
    public ProcessadorBoletos(LeituraRetorno leituraRetorno){
        this.leituraRetorno = leituraRetorno;
    }

    /**
     * Realiza de fato o processamento de um dado arquivo de retorno de boleto bancário,
     * utilizando uma estratégia definida em {@link #leituraRetorno}.
     * Este método pode realizar diversas operações após a leitura do arquivo,
     * como gravar dados em um banco, enviar emails de notificação, etc.
     * Neste caso, por simplificação, estamos apenas imprimindo os dados no terminal.
     *
     * @param caminhoArquivo Nome do arquivo a ser lido
     */
    public void processar(URI caminhoArquivo){
        System.out.println("Boletos");
        System.out.println("----------------------------------------------------------------------------------");
        List<Boleto> boletos = leituraRetorno.lerArquivo(caminhoArquivo);
        for (Boleto boleto : boletos) {
            System.out.println(boleto);
        }
    }

    /**
     * Altera a estratégia a ser utilizada para leitura de arquivos de retorno de boletos bancários.
     * @param leituraRetorno nova estratégia a ser utilizada
     */
    public void setLeituraRetorno(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
}
