package com.manoelcampos.retornoboleto;

import java.util.List;

/**
 * Realiza a leitura de arquivos de retorno de boletos bancários no formato do Bradesco.
 * Esta classe usa o padrão Strategy, representando a implementação da estratégia {@link LeituraRetorno}.
 *
 * @author Manoel Campos da Silva Filho
 */
public class LeituraRetornoBradesco implements LeituraRetorno {
    @Override
    public List<Boleto> lerArquivo(String nomeArquivo) {
        throw new UnsupportedOperationException("Método não implementado ainda. Apague esta linha quando for implementá-lo.");
    }
}
