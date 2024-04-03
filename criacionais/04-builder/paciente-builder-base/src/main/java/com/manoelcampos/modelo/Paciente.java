package com.manoelcampos.modelo;

public class Paciente {
    private long id;

    private String nome;
    private char sexo;

    private String cpf;

    private String rg = "";

    private String orgaoEmissorRg = "";

    private String cidade;

    private String uf;

    private double peso;

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

    public final void setNome(String nome) {
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

    public final void setCpf(String cpf) {
        if(cpf.isBlank()){
            throw new IllegalArgumentException("CPF é obrigatório.");
        }

        this.cpf = cpf;
    }

    public final void setCidade(String cidade) {
        if(cidade.isBlank()){
            throw new IllegalArgumentException("Cidade é obrigatória.");
        }

        this.cidade = cidade;
    }

    public final void setUf(String uf) {
        if(uf.isBlank()){
            throw new IllegalArgumentException("UF é obrigatória.");
        }

        this.uf = uf;
    }

    /**
     * Id que identifica unicamente um paciente.
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgaoEmissorRg() {
        return orgaoEmissorRg;
    }

    public void setOrgaoEmissorRg(String orgaoEmissorRg) {
        this.orgaoEmissorRg = orgaoEmissorRg;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    /** Peso para cálculo do IMC. */
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    /** Altura para cálculo do IMC. */
    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
