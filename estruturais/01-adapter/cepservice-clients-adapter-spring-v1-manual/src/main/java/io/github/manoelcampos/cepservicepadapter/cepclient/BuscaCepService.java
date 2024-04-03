package io.github.manoelcampos.cepservicepadapter.service;

import io.github.manoelcampos.cepservicepadapter.model.Endereco;

/**
 * Interface para implementação de clientes de
 * API REST de busca de endereço pelo CEP.
 *
 * @author Manoel Campos da Silva Filho
 */
public interface BuscaCepService {
    Endereco buscaEndereco(String cep);
}
