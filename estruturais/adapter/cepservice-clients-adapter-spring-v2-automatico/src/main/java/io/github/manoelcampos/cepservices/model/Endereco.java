package io.github.manoelcampos.cepservices.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Manoel Campos da Silva Filho
 */
@Data @JsonIgnoreProperties(ignoreUnknown = true)
public class Endereco {
    @JsonAlias("address")
    private String logradouro;
    private String complemento;

    @JsonAlias("district")
    private String bairro;

    @JsonAlias({"city", "cidade"})
    private String localidade;

    @JsonAlias("state")
    private String uf;

    @JsonAlias("code")
    private String cep;
}
