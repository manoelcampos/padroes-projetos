package com.manoelcampos.cepservice;

import com.manoelcampos.model.Endereco;

/**
 * Define uma interface para a implementação
 * de serviços de busca de CEP.
 * 
 * @author Manoel Campos da Silva Filho
 */
public interface CepService {
    /**
     * Busca um endereço a partir de um CEP.
     * @param cep CEP para buscar o endereço
     * @return o {@link Endereco} correspondente ao CEP informado
     */
    Endereco buscaEndereco(String cep);
}
