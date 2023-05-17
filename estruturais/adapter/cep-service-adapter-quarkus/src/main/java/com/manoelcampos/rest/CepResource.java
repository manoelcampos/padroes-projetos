package com.manoelcampos.rest;

import com.manoelcampos.cepservice.CepService;
import com.manoelcampos.model.Endereco;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Este é um Controller REST que fornece uma API para consulta
 * de endereços a partir do CEP.
 *
 * <p>O framework Quarkus recomenda que os atributos injetados
 * tenham visibilidade package, pois ele faz modificações
 * no bytecode gerado.
 * </p>
 */
@Path("/endereco")
@RequestScoped
public class CepResource {
    /**
     * Injeta (instancia automaticamente) um objeto de serviço de CEP.
     * Como temos dois serviços de CEP que podemos consultar,
     * a lógica de qual serviço será usado foi definida na classe
     * {@link com.manoelcampos.config.Producers}.
     */
    @Inject
    CepService cepService;

    @GET
    @Path("{cep}")
    @Produces(MediaType.APPLICATION_JSON)
    public Endereco endereco(@PathParam("cep") final String cep) {
        return cepService.buscaEndereco(cep);
    }
}
