package io.github.manoelcampos.cepservicepadapter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Manoel Campos da Silva Filho
 */
@JsonIgnoreProperties(ignoreUnknown = true) @Getter @Setter @ToString
public class Endereco {
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String cep;
}
