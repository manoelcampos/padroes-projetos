package com.manoelcampos.modelo;

/**
 * Classe que representa pacientes registrados no sistema.
 * A classe possui muitos atributos e vários deles são obrigatórios.
 * Incluir um construtor público que recebe todos os atributos ou
 * os atributos obrigatórios (que neste caso são muitos),
 * não é uma boa prática.
 * De acordo com as práticas do Código Limpo,
 * um bom método dever ter no máximo 3 parâmetros.
 * Um construtor público com 10 parâmetros seria inadequado
 * e torna a chamada do construtor bastante confusa.
 * Ao ver uma chamada como
 * {@code new Paciente(1, "Manoel", 'M', "89278102971", "123.456", "SSP-TO", "Palmas", "TO", 80, 1.85)},
 * é difícil saber o que cada valor representa. Por exemplo, o que é o valor 123.456 e o 80?
 *
 * <p>Não utilizando um construtor público que receba esses inúmeros parâmetros,
 * não teremos como garantir que o objeto seja instanciado com todos os atributos
 * obrigatórios.</p>
 *
 * <p>Desta forma, a classe utiliza o padrão Builder para evitar ter um construtor público
 * com muitos parâmetros e, ao mesmo tempo, garantir que atributos obrigatórios sejam preenchidos.</p>
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

    private Paciente(
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

    /**
     * Método auxiliar para tornar mais conveniente a instanciação de um {@link Builder} a ser
     * usado para construir objetos {@link Paciente}.
     *
     * Ele não é de fato necessário, mas ao utilizá-lo, no lugar de escrever {@code new Paciente.Builder()},
     * podemos simplesmente escrever {@code Paciente.newBuilder()}.
     * Observe que a palavra "new" fica no nome do método, deixando totalmente claro
     * o que é que estamos instanciando.
     *
     * @return um novo {@link Builder} para construir Pacientes.
     */
    public static Builder newBuilder(){
        return new Builder();
    }

    /**
     * Classe Builder de Pacientes, sendo responsável
     * por coletar os dados necessários para construir objetos {@link Paciente}.
     * Ela foi implementada como uma inner class (uma classe dentro de outra).
     * Com este Builder, e uma vez que o construtor de Paciente é privado,
     * para instanciar Pacientes podemos executar, por exemplo:
     *
     * <pre>
     * {@code Paciente p = Paciente.newBuilder().nome("Raysa").sexo('F').altura(1.7).build();}
     * </pre>
     *
     * <p>Somente ao chamar o método {@link #build()} é que a classe
     * tentará criar um {@link Paciente}.
     * Se algum atributo obrigatório não tiver sido informado,
     * a classe {@link Paciente} lançará uma exceção informando isso.
     * </p>
     *
     * <p>Observe que implementar o padrão Builder manualmente é totalmente cansativo e
     * gera uma imensa duplicação de código.
     * Bibliotecas como a <a href="http://immutables.github.io">Immutables</a> possuem recursos
     * para gerar tais builders automaticamente.</p>
     *
     * <p>A duplicação de código é nítida. Todos os atributos da classe a ser construída pelo builder ({@link Paciente} neste caso)
     * estarão duplicados na classe Builder. Adicionalmente, teremos os mesmos setters aqui,
     * apenas com um nome diferente e sem as regras de validação (que devem ser feitas na classe {@link Paciente}).
     * Como não temos getters, o prefixo "set" para os setters é desnecessário e apenas
     * tornaria o uso do Builder mais trabalhoso.
     * Por isso, cada método setter tem o mesmo nome do seu respectivo atributo.
     * </p>
     *
     * <p>
     * Um Builder deve fornecer uma <a href="https://en.wikipedia.org/wiki/Fluent_interface">API Fluente</a>,
     * que permite encadear chamadas de métodos. Assim, no lugar de escrever algo como:
     * <pre>
     *     builder.nome("Manoel");
     *     builder.sexo('M');
     *     builder.cidade("Palmas");
     *     Paciente p = builder.build();
     * </pre>
     * </p>
     *
     * onde temos que repetir o nome do objeto a partir do qual estamos chamando os métodos,
     * podemos encadear as chamadas como:
     *
     * <pre>
     *     {@code Paciente p = builder.nome("Manoel").sexo('M').cidade("Palmas").build();}
     * </pre>
     *
     * Para ser possível este encadeamente, basta fazer os métodos retornarem a própria classe no lugar de void.
     * Assim, todos os setters como {@link #nome(String)} retornam {@link Builder}.
     *
     * <p>Por fim, se existir alguma ordem em que determinados atributos
     * devem ser settados, com o Builder não teremos problemas e podemos setar
     * os atributos na ordem que bem entendermos.
     * Isso porque o builder apenas armazena os dados localmente dentro dele.
     * Somente quando chamarmos o método {@link #build()} é que ele
     * vai pegar tais dados e chamar o construtor de {@link Paciente}.</p>
     */
    public static class Builder{
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

        /**
         * Método que constroi (instancia) um paciente, depois de os dados
         * necessários terem sido armazenados pelo builder com a chamada
         * dos métodos que tem o mesmo nome dos atributos,
         * como {@link #nome(String)}, {@link #cpf(String)}, etc.
         *
         * @return um novo {@link Paciente} caso todos os dados obrigatórios tenham sido armazenados pela
         *         chamada dos métodos mencionados acima.
         */
        public Paciente build(){
            return new Paciente(id, nome, sexo, cpf, rg, orgaoEmissorRg, cidade, uf, peso, altura);
        }
        
        public Builder id(final long id) {
            this.id = id;
            return this;
        }

        public Builder nome(final String nome) {
            this.nome = nome;
            return this;
        }

        public Builder sexo(final char sexo) {
            this.sexo = sexo;
            return this;
        }

        public Builder cpf(final String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder rg(final String rg) {
            this.rg = rg;
            return this;
        }

        public Builder orgaoEmissorRg(final String orgaoEmissorRg) {
            this.orgaoEmissorRg = orgaoEmissorRg;
            return this;
        }

        public Builder cidade(final String cidade) {
            this.cidade = cidade;
            return this;
        }

        public Builder uf(final String uf) {
            this.uf = uf;
            return this;
        }

        public Builder peso(final double peso) {
            this.peso = peso;
            return this;
        }

        public Builder altura(final double altura) {
            this.altura = altura;
            return this;
        }
    }
}
