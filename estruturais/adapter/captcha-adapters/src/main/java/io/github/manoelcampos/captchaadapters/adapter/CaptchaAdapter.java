package io.github.manoelcampos.captchaadapters.adapter;

import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Objects;

/**
 * Uma interface para implementar adapters de geradores de captcha offline.
 * @author Manoel Campos
 */
public interface CaptchaAdapter {
    byte[] gerar();

    default boolean isValido(final String codigo){
        // Faz comparação garantindo que não dará NullPointerException em caso algum dos parâmetros seja Null
        return Objects.equals(codigo, getCodigo());
    }

    String getCodigo();

    /**
     * Obtém um objeto {@link BufferedImage}, contendo uma imagem, para um array de bytes.
     * Isto permite a um endpoints retornar a imagem gerada em memória.
     * @param image imagem pra obter um array de bytes
     * @return array de bytes da imagem
     */
    @SneakyThrows
    default byte[] bufferedImageToByteArray(final BufferedImage image) {
        final var baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }
}
