package com.manoelcampos.retornoboleto;

import java.util.List;

/**
 * Define um contrato para implementação de estratégias
 * de leitura de arquivos de retorno de bancos brasileiros (como Banco do Brasil e Bradesco).
 *
 * @author Manoel Campos da Silva Filho
 */
public interface LeituraRetorno {
    List<Boleto> lerArquivo(String nomeArquivo) ;
}
