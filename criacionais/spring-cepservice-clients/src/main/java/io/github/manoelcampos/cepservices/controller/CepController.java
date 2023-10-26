package io.github.manoelcampos.cepservices.controller;

import io.github.manoelcampos.cepservices.cepclient.CepServiceClient;
import io.github.manoelcampos.cepservices.model.Endereco;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller REST que fornece uma API para consulta
 * de endereços a partir do CEP.
 */
@RestController @RequestMapping("/endereco")
@AllArgsConstructor
public class CepController {

    /**
     * É injetado (instanciado automaticamente) um cliente para acesso a um serviço de CEP.
     * A injeção ocorre magicamente pela inclusão de um construtor que
     * receba este atributo como parâmetro.
     * Tal construtor é criado automaticamente pela biblioteca Lombok
     * com a anotação {@link AllArgsConstructor}.
     */
    private final CepServiceClient cepServiceClient;

    @GetMapping("/{cep}")
    public Endereco getEndereco(@PathVariable final String cep) {
        return cepServiceClient.getEndereco(cep);
    }
}
