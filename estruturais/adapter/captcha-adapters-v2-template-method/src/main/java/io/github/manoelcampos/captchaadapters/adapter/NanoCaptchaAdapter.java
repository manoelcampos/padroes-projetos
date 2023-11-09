package io.github.manoelcampos.captchaadapters.adapter;

import net.logicsquad.nanocaptcha.image.ImageCaptcha;
import org.springframework.web.context.annotation.SessionScope;

import java.awt.image.BufferedImage;

/**
 * @author Manoel Campos
 * @see <a href="https://github.com/logicsquad/nanocaptcha">Nano Captcha</a>
 */
@SessionScope
public class NanoCaptchaAdapter extends AbstractCaptchaAdapter<ImageCaptcha> {

    @Override
    protected ImageCaptcha newCaptcha() {
        return new ImageCaptcha.Builder(200, 50).addContent().build();
    }

    @Override
    protected BufferedImage newImage(ImageCaptcha captcha) {
        return captcha.getImage();
    }

    @Override
    protected String newCode(ImageCaptcha captcha) {
        return captcha.getContent();
    }
}
