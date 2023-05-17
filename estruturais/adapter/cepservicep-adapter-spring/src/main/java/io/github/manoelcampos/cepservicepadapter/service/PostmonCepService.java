package io.github.manoelcampos.cepservicepadapter.service;

import io.github.manoelcampos.cepservicepadapter.model.Endereco;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Implementação de cliente para o serviço https://postmon.com.br
 *
 * @author Manoel Campos da Silva Filho
 */
public class PostmonCepService implements BuscaCepService {
    public static final String BASE_URL = "https://api.postmon.com.br";
    public static final String ENDPOINT_URL = "/v1/cep/%s";
    private final WebClient client;

    public PostmonCepService() {
        client = WebClient.builder().baseUrl(BASE_URL).build();
    }

    @Override
    public Endereco buscaEndereco(final String cep) {
        return client.get().uri(ENDPOINT_URL.formatted(cep)).retrieve().bodyToMono(Endereco.class).block();
    }
}
