package io.github.manoelcampos.cepservices.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author Manoel Campos da Silva Filho
 */
@Data @JsonIgnoreProperties(ignoreUnknown = true)
public class Endereco {
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String cep;
}
