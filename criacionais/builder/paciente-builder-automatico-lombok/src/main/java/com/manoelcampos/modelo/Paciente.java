package com.manoelcampos.modelo;


import lombok.*;

@Builder @Getter @Setter
public class Paciente {
    /**
     * Id que identifica unicamente um paciente.
     */
    private long id;

    @NonNull
    private String nome;
    private char sexo;

    @NonNull
    private String cpf;

    @NonNull
    @Builder.Default
    private String rg = "";

    @NonNull
    @Builder.Default
    private String orgaoEmissorRg = "";

    @NonNull
    private String cidade;

    @NonNull
    private String uf;

    /** Peso para cálculo do IMC. */
    private double peso;

    /** Altura para cálculo do IMC. */
    private double altura;

    Paciente(long id, String nome, char sexo, String cpf, String rg, String orgaoEmissorRg, String cidade, String uf, double peso, double altura) {
        this.setId(id);
        this.setNome(nome);
        this.setSexo(sexo);
        this.setCpf(cpf);
        this.setRg(rg);
        this.setOrgaoEmissorRg(orgaoEmissorRg);
        this.setCidade(cidade);
        this.setUf(uf);
        this.setPeso(peso);
        this.setAltura(altura);
    }

    public final void setNome(@NonNull String nome) {
        if(nome.isBlank()){
            throw new IllegalArgumentException("Nome é obrigatório.");
        }

        this.nome = nome;
    }

    public final void setSexo(char sexo) {
        if(sexo == '\0'){
            throw new IllegalArgumentException("Sexo é obrigatório.");
        }

        sexo = Character.toUpperCase(sexo);
        if(sexo != 'M' && sexo != 'F'){
            throw new IllegalArgumentException("Sexo inválido. Informe M ou F.");
        }

        this.sexo = sexo;
    }

    public final void setCpf(@NonNull String cpf) {
        if(cpf.isBlank()){
            throw new IllegalArgumentException("CPF é obrigatório.");
        }

        this.cpf = cpf;
    }

    public final void setCidade(@NonNull String cidade) {
        if(cidade.isBlank()){
            throw new IllegalArgumentException("Cidade é obrigatória.");
        }

        this.cidade = cidade;
    }

    public final void setUf(@NonNull String uf) {
        if(uf.isBlank()){
            throw new IllegalArgumentException("UF é obrigatória.");
        }

        this.uf = uf;
    }
}
