package io.github.manoelcampos.captchaadapters.controllers;

import io.github.manoelcampos.captchaadapters.adapter.CaptchaAdapter;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @author Manoel Campos
 */
@RestController
@RequestMapping("/captcha")
@SessionScope
@AllArgsConstructor
public class CaptchaController {
    private final CaptchaAdapter captcha;

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
