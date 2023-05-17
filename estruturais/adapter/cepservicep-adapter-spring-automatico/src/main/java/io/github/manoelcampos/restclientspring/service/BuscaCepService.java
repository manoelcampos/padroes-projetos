package io.github.manoelcampos.restclientspring.service;

import io.github.manoelcampos.restclientspring.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Interface a ser implementada pela biblioteca Spring Cloud OpenFeign
 * para consumo de uma API REST externa.
 * A classe SpringApplication do seu projeto deve ser anotada
 * com {@link org.springframework.cloud.openfeign.EnableFeignClients}.
 *
 * @author Manoel Campos da Silva Filho
 */
@FeignClient(name = "busca-cep", url = "${buscacep.baseurl}")
public interface BuscaCepService {
    @GetMapping("${buscacep.buscaEnderecoEndpoint}")
    Endereco buscaEndereco(@PathVariable String cep);
}
