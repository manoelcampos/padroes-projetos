package com.manoelcampos.retornoboleto;

import java.util.function.Function;

/**
 * Classe que implementa uma Simple Factory
 * para encapsular a lógica de criação das estratégias
 * de leitura de arquivo de retorno de boleto bancário.
 *
 * <p>Observe que a classe e o método {@link #newStrategy(String)}
 * foram definidos com visibilidade package
 * pois, neste caso, não quero que a classe seja utilizada
 * fora do pacote.
 * Assim, somente classes como {@link ProcessarBoletos} podem acessar esta factory
 * para criar objetos.</p>
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

    /**
     * Cria uma instância da estratégia ({@link Function}) para
     * processamento de um determinado tipo de arquivo de retorno.
     * A estratégia é automaticamente selecionada a partir
     * do nome do arquivo que deve possuir o nome do banco.
     *
     * @param nomeArquivo nome do arquivo de retorno de boletos bancários de um determinado banco,
     *                    cujo nome do banco deve estar dentro do nome do arquivo.
     * @return
     */
    static Function<String[], Boleto> newStrategy(String nomeArquivo){
        Function<String[], Boleto> estrategia;
        if(nomeArquivo.contains("banco-brasil")){
            /**
             * Obseve que como estamos usando programação funcional,
             * a estratégia de processamento do arquivo não é um objeto,
             * mas uma função. Assim, não estamos de fato instanciando
             * um objeto, mas apenas obtendo uma referência (um link)
             * para a função que será usada pela classe
             * {@link ProcessarBoletos}.
             * Os caracteres :: indicam que estamos apenas obtendo
             * a referência de uma função e armazenando
             * em uma variável do tipo {@link Function}.
             */
            estrategia = LeituraRetorno::processarLinhaBancoBrasil;
        }
        else if(nomeArquivo.contains("bradesco")){
            estrategia = LeituraRetorno::processarLinhaBradesco;
        }
        else throw new UnsupportedOperationException("Banco não identificado ou não suportado para o arquivo " + nomeArquivo);

        return estrategia;
    }
}

