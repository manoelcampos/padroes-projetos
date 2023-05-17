package io.github.manoelcampos.cepservicepadapter.controller;

import io.github.manoelcampos.cepservicepadapter.service.BuscaCepService;
import io.github.manoelcampos.cepservicepadapter.model.Endereco;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller que intermedia o acesso a um serviço de CEP.
 * Ele recebe as requisições e encaminho para o serviço de
 * CEP atualmente configurado.
 *
 * <p>Assim, caso deseje-se mudar o serviço utilizado,
 * aplicações clientes que estejam acessando este controller REST
 * não precisam alterar o endereço do serviço de CEP
 * (pois tais clientes não se comunicam diferente com o serviço de CEP).
 * </p>
 * @author Manoel Campos da Silva Filho
 */
@RestController
@RequestMapping("/cep")
public class BuscaCepController {
    private final BuscaCepService cepService;

    public BuscaCepController(final BuscaCepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/{cep}")
    public Endereco buscaEndereco(@PathVariable String cep){
        System.out.println("Busca de endereço pelo CEP usando " + cepService.getClass().getSimpleName());
        return cepService.buscaEndereco(cep);
    }

}
