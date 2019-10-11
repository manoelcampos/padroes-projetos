package com.manoelcampos.exportador;

/**
 * @author Manoel Campos da Silva Filho
 */
public class Produto {
    private int id;
    private String descricao;
    private String marca;
    private String modelo;
    private int estoque;

    public Produto(){
    }

    /**
     * Construtor que inicializa todos os atributos do produto.
     * Ele possui uma grande quantidade de parâmetros, que não é recomendável
     * por tornar a chamada do método confusa.
     * Ele foi usado aqui apenas para tornar o exemplo mais simples.
     * Sempre que possível, defina métodos com no máximo 3 parâmetros.
     *
     * @param id
     * @param descricao
     * @param marca
     * @param modelo
     * @param estoque
     */
    public Produto(int id, String descricao, String marca, String modelo, int estoque) {
        this.id = id;
        this.descricao = descricao;
        this.marca = marca;
        this.modelo = modelo;
        this.estoque = estoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
