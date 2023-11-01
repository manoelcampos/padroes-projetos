package io.github.manoelcampos.captchaadapters.adapter;

/**
 * @author Manoel Campos
 */
abstract class AbstractCaptchaAdapter implements CaptchaAdapter {
    protected String codigo = "";

    @Override
    public String getCodigo() {
        return codigo == null ? "" : codigo;
    }
}
