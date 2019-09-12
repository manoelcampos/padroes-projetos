package com.manoelcampos.retornoboleto;

/**
 *
 * @author manoelcampos
 */
public class Principal {
    public static void main(String[] args) {
        ProcessarBoletos processar =
                new ProcessarBoletos(ProcessarBoletos::lerBancoBrasil);
        String nomeArquivo = "/Users/manoelcampos/Documents/IFTO/padroes-projetos/strategy/retorno-boleto-funcional/src/main/resources/banco-brasil-1.csv";
        processar.processar(nomeArquivo);
    }
}
