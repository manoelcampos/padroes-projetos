package com.manoelcampos.model;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

/**
 * Classe que gerencia as configurações do sistema, armazenadas no arquivo no
 * application.properties do Quarkus.
 *
 * Aqui estamos usando a biblioteca
 * <a href="https://microprofile.io/project/eclipse/microprofile-config">MicroProfile Config</a>
 * que já é incluída pelo Quarkus para permitir obter
 * as configurações do arquivo application.properties por meio da anotação
 * &#64;{@link ConfigProperty}.
 *
 * <p>Aqui estamos usando a anotação &#64;{@link ApplicationScoped}
 * do CDI como uma forma de definir um objeto Singleton, que possui
 * uma única instância para todos os usuários da aplicação.
 * Assim, as configurações são as mesmas para todos.
 * Se for alterada, todos os usuários poderão ver as alterações.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
@ApplicationScoped
public class Config {
    @ConfigProperty(name = "formatoRelatorios")
    private String formatoRelatorios = "pdf";

    @ConfigProperty(name = "tipoGraficos")
    private String tipoGraficos = "barras";

    public String getFormatoRelatorios() {
        return formatoRelatorios;
    }

    public void setFormatoRelatorios(String formatoRelatorios) {
        this.formatoRelatorios = formatoRelatorios;
    }

    public String getTipoGraficos() {
        return tipoGraficos;
    }

    public void setTipoGraficos(String tipoGraficos) {
        this.tipoGraficos = tipoGraficos;
    }
}
