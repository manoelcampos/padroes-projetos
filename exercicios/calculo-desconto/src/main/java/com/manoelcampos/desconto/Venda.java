package com.manoelcampos.desconto;

import java.time.LocalDate;

/**
 * Venda realizada para um {@link Cliente}.
 * @author Manoel Campos da Silva Filho
 */
public class Venda {
    private long id;
    private Cliente cliente;
    private LocalDate data;
    private double valorTotal;

    public Venda() {/**/}

    public Venda(Cliente cliente, LocalDate data, double valorTotal) {
        this.cliente = cliente;
        this.data = data;
        this.valorTotal = valorTotal;
    }
}
