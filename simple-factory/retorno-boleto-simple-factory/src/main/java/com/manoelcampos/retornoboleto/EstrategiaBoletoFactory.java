package com.manoelcampos.retornoboleto;

import java.util.function.Function;

/**
 * Classe que implementa uma Simple Factory
 * para encapsular a lógica de criação das estratégias
 * de leitura de arquivo de retorno de boleto bancário.
 *
 * <p>Observe que a classe e o método {@link #createStrategy(String)}
 * foram definidos com visibilidade package
 * pois, neste caso, não quero que a classe seja utilizada
 * fora do pacote.
 * Assim, somente classes como {@link ProcessarBoletos} podem
 * acessar esta factory.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
class EstrategiaBoletoFactory {
    /**
     * Construtor privado para impedir que a fábrica
     * seja instanciada, pois o único método dela
     * é estático.
     */
    private EstrategiaBoletoFactory(){/**/}

    static Function<String[], Boleto> createStrategy(String nomeArquivo){
        Function<String[], Boleto> estrategia;
        if(nomeArquivo.contains("banco-brasil")){
            estrategia = LeituraRetorno::processarLinhaBancoBrasil;
        }
        else if(nomeArquivo.contains("bradesco")){
            estrategia = LeituraRetorno::processarLinhaBradesco;
        }
        else throw new UnsupportedOperationException("Banco não identificado ou não suportado para o arquivo " + nomeArquivo);

        return estrategia;
    }
}

