package com.manoelcampos.exportador;

/**
 * @author Manoel Campos da Silva Filho
 */
public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String cidade;

    public Cliente(int id, String nome, String cpf, String cidade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
