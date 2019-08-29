package com.manoelcampos.retornoboleto;

import java.util.function.Function;

/**
 *
 * @author manoelcampos
 */
public class ProcessaCampoArquivo<T> {
    private final String campo;
    private final Function<String, T> conversor;

    public ProcessaCampoArquivo(String nome, Function<String, T> conversor){
        this.campo = nome;
        this.conversor = conversor;
    }
    
    public String getCampo() {
        return campo;
    }

    public T converter(String valor) {
        return conversor.apply(valor);
    }
}
