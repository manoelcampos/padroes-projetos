package io.github.manoelcampos.cepservices.cepclient;


import io.github.manoelcampos.cepservices.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Define uma interface para a implementação automática de um cliente de serviço de busca de CEP
 * utilizando a biblioteca <a href="https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/">OpenFeign</a>.
 *
 * <p>Exemplos de outros serviços disponíveis que podem ser consumidos:
 * <ul>
 *     <li>Postmon: https://api.postmon.com.br/v1/cep/{cep}</li>
 *     <li>ViaCep: https://viacep.com.br/ws/{cep}/json</li>
 *     <li>Widenet: https://ws.apicep.com/cep/{cep}.json</li>
 * </ul>
 * </p>
 * 
 * @author Manoel Campos da Silva Filho
 */
@FeignClient(value = "cepservice", url = "https://viacep.com.br")
public interface CepServiceClient {
    /**
     * Busca um endereço a partir de um CEP.
     * @param cep CEP para buscar o endereço
     * @return o {@link Endereco} correspondente ao CEP informado
     */
    @GetMapping("/ws/{cep}/json")
    Endereco getEndereco(@PathVariable String cep);
}
