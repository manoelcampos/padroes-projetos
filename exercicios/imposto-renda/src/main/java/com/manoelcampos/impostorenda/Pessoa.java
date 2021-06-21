package com.manoelcampos.impostorenda;

/**
 * @author Manoel Campos da Silva Filho
 */
public abstract class Pessoa {
    private long id;
    private String nome;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
