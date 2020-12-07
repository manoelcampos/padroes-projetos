package com.manoelcampos.retornoboleto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Processa arquivos de retorno de boletos bancários.
 * É utilizada uma versão da Simple Factory {@link EstrategiaBoletoFactory}
 * que descobre automaticamente qual a classe de estratégia será utilizada,
 * de acordo com o nome do arquivo a ser processado.
 *
 * @author Manoel Campos da Silva Filho
 */
public class ProcessarBoletos {
    public void processar(String nomeArquivo){
        LeituraRetorno estrategia = EstrategiaBoletoFactory.newStrategy(nomeArquivo);
        System.out.println("Utilizando a classe " + estrategia.getClass().getSimpleName() + " para ler arquivo " + nomeArquivo + "\n");

        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));
            String line;
            List<Boleto> boletos = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] vetor = line.split(";");
                Boleto boleto = estrategia.processarLinhaArquivo(vetor);
                boletos.add(boleto);
                System.out.println(boleto);
            }
        }catch(IOException ex){
            throw new UncheckedIOException(ex);
        }
    }
}
