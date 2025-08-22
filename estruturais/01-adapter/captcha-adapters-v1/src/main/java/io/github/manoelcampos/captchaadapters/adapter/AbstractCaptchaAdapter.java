package io.github.manoelcampos.captchaadapters.adapter;

import java.util.Objects;

/**
 * @author Manoel Campos
 */
abstract class AbstractCaptchaAdapter implements CaptchaAdapter {
    protected String codigo = "";

    @Override
    public String getCodigo() {
        return Objects.requireNonNullElse(codigo, "");
    }
}
