package com.manoelcampos.desconto;

import java.time.LocalDate;

/**
 * Venda realizada para um {@link Cliente}.
 * @author Manoel Campos da Silva Filho
 */
public class Venda {
    private long id;
    private LocalDate data;
    private double valorTotal;

    public Venda() {/**/}

    public Venda(long id, LocalDate data, double valorTotal) {
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
