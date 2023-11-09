package io.github.manoelcampos.captchaadapters.adapter;

import com.mewebstudio.captcha.Captcha;
import com.mewebstudio.captcha.GeneratedCaptcha;
import net.logicsquad.nanocaptcha.image.ImageCaptcha;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.awt.image.BufferedImage;

/**
 * @author Manoel Campos
 * @see <a href="https://github.com/mewebstudio/java-captcha-generator">Captcha Generator</a>
 */
@SessionScope
@Component
public class CaptchaGeneratorAdapter extends AbstractCaptchaAdapter<GeneratedCaptcha> {
    @Override
    protected String newCode(GeneratedCaptcha captcha) {
        return captcha.getCode();
    }

    @Override
    protected BufferedImage newImage(GeneratedCaptcha captcha) {
        return captcha.getImage();
    }

    @Override
    protected GeneratedCaptcha newCaptcha() {
        return new Captcha().generate();
    }
}
