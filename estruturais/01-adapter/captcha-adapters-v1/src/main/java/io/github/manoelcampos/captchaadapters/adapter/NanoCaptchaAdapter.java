package io.github.manoelcampos.captchaadapters.adapter;

import net.logicsquad.nanocaptcha.image.ImageCaptcha;
import org.springframework.stereotype.Component;

/**
 * @author Manoel Campos
 * @see <a href="https://github.com/logicsquad/nanocaptcha">Nano Captcha</a>
 */
@Component
public class NanoCaptchaAdapter extends AbstractCaptchaAdapter {

    @Override
    public byte[] gerar() {
        final var captcha = ImageCaptcha.create();
        this.codigo = captcha.getContent();
        return bufferedImageToByteArray(captcha.getImage());
    }
}
