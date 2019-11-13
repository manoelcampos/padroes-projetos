package com.manoelcampos.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import com.manoelcampos.cepservice.CepService;
import com.manoelcampos.model.Endereco;

@Controller
public class CepController {
    @Inject
    private CepService cepService;

    @Inject
    private Result result;

    @Get("/endereco")
    public void index() {
        result.include("msg", cepService.buscaEndereco("77021090"));
    }

    @Get("/endereco/{cep}")
    public Endereco endereco(final String cep) {
        return cepService.buscaEndereco(cep);
    }
}
