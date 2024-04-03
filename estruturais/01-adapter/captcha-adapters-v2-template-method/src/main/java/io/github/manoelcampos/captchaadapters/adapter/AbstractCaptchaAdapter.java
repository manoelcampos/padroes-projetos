package io.github.manoelcampos.captchaadapters.adapter;

import lombok.Data;

import java.awt.image.BufferedImage;

/**
 * @author Manoel Campos
 * @param <C> Tipo de objeto Captcha a ser instanciado (de acordo com o tipo usado pela biblioteca de captcha sendo adaptada)
 */
@Data
abstract class AbstractCaptchaAdapter<C> implements CaptchaAdapter {
    private String codigo = "";


    /**
     * Gera a imagem do captcha e retorna como um vetor de bytes.
     * Implementa o padrão Template Method
     * @return
     */
    @Override
    public final byte[] gerar() {
        final var captcha = newCaptcha();
        this.codigo = newCode(captcha);
        return bufferedImageToByteArray(newImage(captcha));
    }

    protected abstract String newCode(C captcha);

    protected abstract BufferedImage newImage(C captcha);

    protected abstract C newCaptcha();
}
