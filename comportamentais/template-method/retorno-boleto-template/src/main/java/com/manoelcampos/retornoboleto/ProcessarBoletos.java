package com.manoelcampos.retornoboleto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Manoel Campos da Silva Filho
 */
public class ProcessarBoletos {
    private LeituraRetorno leituraRetorno;

    public ProcessarBoletos(LeituraRetorno leituraRetorno){
        this.leituraRetorno = leituraRetorno;
    }

    /**
     * Processa um arquivo de retorno de boleto bancário
     * e imprime o resultado no terminal (mas
     * poderia fazer qualquer outra coisa como gravar em um banco
     * de dados, gerar um PDF, enviar um email com confirmação
     * de pagamento do boleto para o cliente, etc).
     *
     * @param nomeArquivo Nome do arquivo a ser processado
     */
    public final List<Boleto> processar(String nomeArquivo){
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
            String line;
            List<Boleto> boletos = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] vetor = line.split(";");
                Boleto boleto = leituraRetorno.processarLinhaArquivo(vetor);
                boletos.add(boleto);
                //System.out.println(boleto);
            }

            return boletos;
        }catch(IOException ex){
            throw new UncheckedIOException(ex);
        }
    }
}
