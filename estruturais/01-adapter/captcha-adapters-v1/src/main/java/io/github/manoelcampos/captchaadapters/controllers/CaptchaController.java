package io.github.manoelcampos.captchaadapters.controllers;

import io.github.manoelcampos.captchaadapters.adapter.CaptchaAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @author Manoel Campos
 */
@RestController
@RequestMapping("/captcha")
@SessionScope
public class CaptchaController {
    @Autowired
    private CaptchaAdapter captcha;

    @GetMapping(value = "/gerar", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] gerar(){
        System.out.println(captcha.getClass().getName());
        final byte[] image = captcha.gerar();
        System.out.println(captcha.getCodigo());
        return image;
    }

    @GetMapping("/confirmar/{codigo}")
    public boolean confirmar(@PathVariable final String codigo){
        return captcha.isValido(codigo);
    }
}
