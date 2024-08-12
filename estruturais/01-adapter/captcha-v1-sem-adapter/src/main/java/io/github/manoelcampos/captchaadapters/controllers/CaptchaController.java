package io.github.manoelcampos.captchaadapters.controllers;

import com.mewebstudio.captcha.Captcha;
import com.mewebstudio.captcha.GeneratedCaptcha;
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
    private GeneratedCaptcha generatedCaptcha;

    @GetMapping(value = "/gerar", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] gerar(){
        this.generatedCaptcha = new Captcha().generate();
        final byte[] image = ImageUtil.bufferedImageToByteArray(generatedCaptcha.getImage());
        System.out.println(generatedCaptcha.getCode());
        return image;
    }

    @GetMapping("/confirmar/{codigo}")
    public boolean confirmar(@PathVariable final String codigo){
        return generatedCaptcha != null && codigo.equals(generatedCaptcha.getCode());
    }
}
