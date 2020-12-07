package com.manoelcampos.modelo;

import org.immutables.builder.Builder;

/**
 * Classe que representa pacientes registrados no sistema.
 * A classe possui muitos atributos e vários deles são obrigatórios.
 * Na versão anterior deste projeto, implementamos o padrão manualmente.
 *
 * <p>Neste projeto, utilizamos a biblioteca
 * <a href="http://immutables.github.io/factory.html">Immutables</a>
 * para gerar automaticamente um builder para esta classe Paciente.
 * Para isto, temos que incluir um construtor público com
 * todos os atributos da classe e anotá-lo com @{@link Builder.Constructor}.
 * Como pode perceber, o incoveniente é que o construtor (que possivelmente terá
 * uma enorme quantidade de parâmetros) ficará disponível para uso fora da classe.
 * </p>
 *
 * <p>A classe gerada terá o nome de {@code PacienteBuilder}, no lugar
 * de ser criada uma inner classe {@code Builder} dentro de {@code Paciente}.
 * Para usar o Builder gerado, podemos escrever um código como:
 * </p>
 *
 * <pre>
 *     Paciente p = new PacienteBuilder()
 *                          .nome("Manoel")
 *                          .sexo('F')
 *                          .cpf("123.012.918-00")
 *                          .altura(1.7)
 *                          .build();
 * </pre>
 *
 */
public class Paciente {
    private long id;
    private String nome;
    private char sexo;
    private String cpf;
    private String rg;
    private String orgaoEmissorRg;
    private String cidade;
    private String uf;
    private double peso;
    private double altura;

    @Builder.Constructor
    public Paciente(
            long id, String nome, char sexo, String cpf, String rg,
            String orgaoEmissorRg, String cidade, String uf, double peso, double altura)
    {
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

    public long getId() {
        return id;
    }

    public final void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public final void setNome(String nome) {
        if(nome == null || nome.isEmpty()){
            throw new IllegalArgumentException("Nome é obrigatório.");
        }

        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public final void setSexo(char sexo) {
        sexo = Character.toUpperCase(sexo);
        if(sexo == '\0'){
            throw new IllegalArgumentException("Sexo é obrigatório.");
        }

        if(sexo != 'M' && sexo != 'F'){
            throw new IllegalArgumentException("Sexo inválido. Informe M ou F.");
        }

        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public final void setCpf(String cpf) {
        if(cpf == null || cpf.isEmpty()){
            throw new IllegalArgumentException("CPF é obrigatório.");
        }

        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public final void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgaoEmissorRg() {
        return orgaoEmissorRg;
    }

    public final void setOrgaoEmissorRg(String orgaoEmissorRg) {
        this.orgaoEmissorRg = orgaoEmissorRg;
    }

    public String getCidade() {
        return cidade;
    }

    public final void setCidade(String cidade) {
        if(cidade == null || cidade.isEmpty()){
            throw new IllegalArgumentException("Cidade é obrigatória.");
        }

        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public final void setUf(String uf) {
        if(uf == null || uf.isEmpty()){
            throw new IllegalArgumentException("UF é obrigatório.");
        }

        this.uf = uf;
    }

    public double getPeso() {
        return peso;
    }

    public final void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public final void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        String s = "Paciente " + id +
                   "\n\tNome: " + nome +
                   "\n\tSexo: " + sexo +
                   "\n\tCPF: " + cpf;
        if(rg != null && !rg.isEmpty() && orgaoEmissorRg != null && !orgaoEmissorRg.isEmpty()){
            s += "\n\tRG: " + rg + " Órgão Emissor: " + orgaoEmissorRg;
        }

        s += "\n\tCidade: " + cidade + " UF: " + uf;
        return s;
    }
}
