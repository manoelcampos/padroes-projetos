package com.manoelcampos.config;

import com.manoelcampos.cepservice.CepService;
import com.manoelcampos.cepservice.PostmonService;
import com.manoelcampos.cepservice.ViaCepService;

import javax.enterprise.inject.Produces;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Alternative;

/**
 * Fábrica que produz automaticamente objetos {@link CepService}
 * e outros tipos de objetos que desejarmos.
 * Veja o método {@link #newCepService()}.
 *
 * @author Manoel Campos da Silva Filho
 */
public class Producers {
    private final static Logger LOGGER = Logger.getLogger(Producers.class.getSimpleName());

    /**
     * Total de instâncias de {@link CepService} solicitadas pelo sistema
     * pelo uso de {@code @Inject CepService cepService}.
     */
    private static int instanciasCepService = 0;

    /**
     * Cria uma nova instância de {@link CepService}.
     * Método chamada automaticamente sempre que for utilizada a anotação @{@link Inject}
     * quando um código como {@code @Inject CepService cepService} for executado em qualquer
     * lugar do código.
     *
     * <p>A injeção de qualquer tipo de objeto funciona por padrão se tivermos
     * o arquivo beans.xml definido com o atributo bean-discovery-mode igual a "all".
     * Com isto, qualquer objeto que possua um construtor padrão pode ser injetado
     * com @Inject.
     * </p>
     *
     * <p>Como todas as implementações de {@link CepService} possuem um construtor padrão,
     * não precisamos de fato desta classe para injetar objetos, como mostrado no projeto anterior.
     * No entanto, estamos usando a classe aqui para definir uma lógica para a criação de tais objetos,
     * que não conseguimos de outra maneira.
     * No projeto anterior, o máximo que conseguimos é marcar
     * a classe que desejamos que seja injetado com a anotação @{@link Default},
     * marcando as outras implementações com @{@link Alternative}.
     * </p>
     *
     * <p>Como temos duas implementações de {@link CepService}, ou seja,
     * temos dois serviços de consulta de CEP que podemos usar,
     * esta fábrica alterna entre o uso de um e outro serviço.
     * Sempre que o contador {@link #instanciasCepService} for par,
     * ele instancia um serviço, quando for ímpar instancia outro.
     * Assim, estamos balanceando a carga das consultas de CEP entre
     * estes dois serviços implementados.</p>
     *
     * <p>A lógica definida aqui serve apenas de exemplo.
     * Podemos definir qualquer lógica que desejarmos.
     * Por exemplo, poderíamos escolher uma das outras alternativas a seguir:
     * <ul>
     *     <li>usar mais vezes o serviço que tiver o menor tempo de resposta.
     *     Para isto, precisaríamos medir o tempo
     *     que o método {@link CepService#buscaEndereco(String)} leva para responder.
     *     </li>
     *     <li>usar apenas um serviço e, caso ele falhe, passar a usar o outro.
     *     </li>
     * </ul>
     * </p>
     *
     * @return uma instância de {@link CepService}
     */
    @Produces
    public CepService newCepService() {
        final CepService cepService;

        if (instanciasCepService++ % 2 == 0)
            cepService = new ViaCepService();
        else cepService = new PostmonService();

        LOGGER.info(
                "Serviço de busca de CEP instanciado pela fábrica: " + cepService.getClass().getName() +
                        ". Total de instâncias criadas: " + instanciasCepService);
        return cepService;
    }

}
