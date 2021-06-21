package com.manoelcampos.desconto;

import java.time.LocalDate;

/**
 * Cliente da loja.
 * @author Manoel Campos da Silva Filho
 */
public class Cliente {
    private long id;
    private String nome;
    private LocalDate dataNascimento;

    public Cliente() {/**/}

    public Cliente(long id, String nome, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
