package io.github.manoelcampos.captchaadapters.adapter;

import net.logicsquad.nanocaptcha.image.ImageCaptcha;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @author Manoel Campos
 * @see <a href="https://github.com/logicsquad/nanocaptcha">Nano Captcha</a>
 */
@SessionScope
public class NanoCaptchaAdapter extends AbstractCaptchaAdapter {

    @Override
    public byte[] gerar() {
        final var captcha = new ImageCaptcha.Builder(200, 50).addContent().build();
        this.codigo = captcha.getContent();
        return bufferedImageToByteArray(captcha.getImage());
    }
}
