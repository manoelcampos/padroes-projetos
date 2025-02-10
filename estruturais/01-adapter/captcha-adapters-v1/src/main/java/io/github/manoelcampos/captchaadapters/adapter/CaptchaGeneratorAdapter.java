package io.github.manoelcampos.captchaadapters.adapter;

import com.mewebstudio.captcha.Captcha;

/**
 * @author Manoel Campos
 * @see <a href="https://github.com/mewebstudio/java-captcha-generator">Captcha Generator</a>
 */
public class CaptchaGeneratorAdapter extends AbstractCaptchaAdapter {

    @Override
    public byte[] gerar() {
        final var generatedCaptcha = new Captcha().generate();
        this.codigo = generatedCaptcha.getCode();
        return bufferedImageToByteArray(generatedCaptcha.getImage());
    }
}
