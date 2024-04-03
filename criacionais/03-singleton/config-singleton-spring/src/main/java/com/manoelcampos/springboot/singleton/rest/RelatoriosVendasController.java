package com.manoelcampos.springboot.singleton.rest;

import com.manoelcampos.springboot.singleton.model.Config;
import com.manoelcampos.springboot.singleton.model.TipoGrafico;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller REST para gerar relatórios de vendas.
 * A classe de fato apenas altera o objeto {@link Config}
 * e o retorna, para podermos ver os valores de seus atributos.
 * Assim, em {@link RelatorioEntregasController}, podemos ver
 * as alterações realizadas aqui, confirmando que temos uma única instância de config.
 * @author Manoel Campos da Silva Filho
 */
@RestController
@RequestMapping("/relatorio/vendas")
public class RelatoriosVendasController {
    private final Config config;

    public RelatoriosVendasController(final Config config) {
        this.config = config;
    }

    @GetMapping("/config")
    public Config getConfig(){
        config.setTipoGrafico(TipoGrafico.COLUNA);
        config.setExtensaoFormatoRelatorio("pdf");
        return config;
    }
}
