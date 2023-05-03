package com.manoelcampos.springboot.singleton.rest;

import com.manoelcampos.springboot.singleton.model.Config;
import com.manoelcampos.springboot.singleton.model.TipoGrafico;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller REST para gerar relatórios de entregas.
 * A classe de fato apenas retorna o objeto {@link Config}
 * para podermos ver os valores de seus atributos.
 * Como o objeto está sendo alterado (apenas para testes)
 * em {@link RelatorioEntregasController}, podemos ver aqui
 * que veremos as alterações realizadas lá.
 * @author Manoel Campos da Silva Filho
 */
@RestController
@RequestMapping("/relatorio/entregas")
public class RelatorioEntregasController {
    private final Config config;

    public RelatorioEntregasController(final Config config) {
        this.config = config;
    }

    @GetMapping("/config")
    public Config getConfig(){
        return config;
    }
}
