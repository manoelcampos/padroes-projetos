package com.manoelcampos.retornoboleto;

import java.util.List;
import java.util.function.Function;

/**
 * @author Manoel Campos da Silva Filho
 */
public class ProcessarBoletos {
    /**
     * {@link Function} que possui a implementação
     * da estratégia para leitura do arquivo de retorno de boleto
     * bancário para um banco específico (como Banco do Brasil, Bradesco, etc).
     */
    private Function<String, List<Boleto>> leituraRetorno;

    public ProcessarBoletos(Function<String, List<Boleto>> leituraRetorno){
        this.leituraRetorno = leituraRetorno;
    }
    
    public void processar(String nomeArquivo){
        List<Boleto> boletos = leituraRetorno.apply(nomeArquivo);
        for (Boleto boleto : boletos) {
            System.out.println(boleto);
        }
    }
}
