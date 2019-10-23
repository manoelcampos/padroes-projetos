package com.manoelcampos.exportador;

/**
 * @author Manoel Campos da Silva Filho
 */
public class Produto {
    /**
     * Último ID gerado automaticamente.
     */
    private static int ultimoId = 0;

    private int id;
    private String descricao;
    private String marca;
    private String modelo;
    private int estoque;

    public Produto(){
        this.id = ++ultimoId;
    }

    /**
     * Construtor que inicializa todos os atributos do produto.
     * Ele possui uma grande quantidade de parâmetros, que não é recomendável
     * por tornar a chamada do método confusa.
     * Ele foi usado aqui apenas para tornar o exemplo mais simples.
     * Sempre que possível, defina métodos com no máximo 3 parâmetros.
     *
     * @param descricao
     * @param marca
     * @param modelo
     * @param estoque
     */
    public Produto(String descricao, String marca, String modelo, int estoque) {
        this();
        this.descricao = descricao;
        this.marca = marca;
        this.modelo = modelo;
        this.estoque = estoque;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
