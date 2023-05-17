package io.github.manoelcampos.cepservicepadapter.service;

import io.github.manoelcampos.cepservicepadapter.model.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Implementação de cliente para o serviço https://viacep.com.br
 *
 * @author Manoel Campos da Silva Filho
 */
@Service
public class ViaCepService implements BuscaCepService {
    public static final String BASE_URL = "https://viacep.com.br";
    public static final String ENDPOINT_URL = "/ws/%s/json";
    private final WebClient client;

    public ViaCepService() {
        client = WebClient.builder().baseUrl(BASE_URL).build();
    }

    @Override
    public Endereco buscaEndereco(final String cep) {
        return client.get().uri(ENDPOINT_URL.formatted(cep)).retrieve().bodyToMono(Endereco.class).block();
    }
}
