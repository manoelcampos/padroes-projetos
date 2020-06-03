package com.manoelcampos.rest;

import com.manoelcampos.model.Config;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Este é um Controller REST que fornece uma API para consulta
 * de endereços a partir do CEP.
 *
 * <p>O framework Quarkus recomenda que os atributos injetados
 * tenham visibilidade package, pois ele faz modificações
 * no bytecode gerado.
 * </p>
 *
 * @author Manoel Campos da Silva Filho
 */
@Path("/config")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ConfigResource {
    /**
     * Injeta (instancia automaticamente) um objeto com as configurações
     * da aplicação.
     * Como a classe {@link Config} foi anotada com &#64;{@link ApplicationScoped},
     * só existirá um único objeto (Singleton) config em toda a aplicação,
     * independentemente de quantos usuários estejam conectados.
     *
     * O atributo é definido com visibilidade package por uma solicitação
     * do Quarkus.
     */
    @Inject
    Config config;

    @GET
    public Config getConfig() {
        return config;
    }

    @PUT
    public void updateConfig(Config newConfig) {
        /**
         * Como o objeto config tem seu ciclo de vida controlado
         * pelo CDI e este parâmetro newConfig não tem,
         * não podemos simplismenter atribuir o último ao primeiro.
         * Precisamos copiar os valores dos atributos de um para o outro.
         */
        config.setFormatoRelatorios(newConfig.getFormatoRelatorios());
        config.setTipoGraficos(newConfig.getTipoGraficos());
    }
}
