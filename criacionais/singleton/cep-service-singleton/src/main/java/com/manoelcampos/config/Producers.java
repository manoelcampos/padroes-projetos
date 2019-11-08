package com.manoelcampos.config;

import com.manoelcampos.cepservice.CepService;
import com.manoelcampos.cepservice.PostmonService;
import com.manoelcampos.cepservice.ViaCepService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Alternative;

/**
 * Fábrica que produz automaticamente objetos {@link CepService}
 * e outros tipos de objetos que desejarmos.
 * Neste caso, é utilizada a anotação @{@link ApplicationScoped}
 * que só permitirá a criação de um único
 * objeto da classe {@link CepService} que será utilizado
 * por toda a aplicação.
 * Como tal classe não possui atributos,
 * não precisamos ter várias instâncias dela pelo sistema.
 * Assim, com a anotação citada, estamos aplicando o padrão Singleton
 * para a criação de um objeto único de tal classe.
 *
 * <p>Anotando um método que retorna um {@link CepService} com  @{@link Produces},
 * em qualquer lugar do sistema solictarmos a injeção de um objeto {@link CepService}
 * com a anotação @{@link Inject}:
 * <ul>
 *  <li>tal método será chamado automaticamente para criar o objeto solicitado com @{@link Inject};</li>
 *  <li>a variável anotada com  @{@link Inject} receberá tal objeto criado anteriormente (tal anotação é usada como uma alternativa
 *  para encapsular a criação de objetos, sem termos que utilizar o operador new em cada local
 *  onde precisarmos de uma instância do objeto).</li>
 * </ul>
 *
 * Com @{@link ApplicationScoped}, garantimos que teremos apenas
 * uma única instância de tal objeto.</p>
 *
 * @author Manoel Campos da Silva Filho
 */
public class Producers {
    private final static Logger LOGGER = Logger.getLogger(Producers.class.getSimpleName());

    @Produces
    @ApplicationScoped
    private CepService getCepService(){
        final CepService cepService = new ViaCepService();
        LOGGER.info("Serviço de busca de CEP instanciado pela fábrica: " + cepService.getClass().getName());
        return cepService;
    };
}
