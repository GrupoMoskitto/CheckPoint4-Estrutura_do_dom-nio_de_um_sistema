package com.crm.model;

import java.time.LocalDate;

public class Contrato {
    private String id;
    private Cliente cliente;
    private Vendedor vendedor;
    private LocalDate dataInicio;
    private double valor;

    public Contrato(String id, Cliente cliente, Vendedor vendedor, LocalDate dataInicio, double valor) {
        this.id = id;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.dataInicio = dataInicio;
        this.valor = valor;
    }

    public String getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Vendedor getVendedor() { return vendedor; }
    public LocalDate getDataInicio() { return dataInicio; }
    public double getValor() { return valor; }

    @Override
    public String toString() {
        return "Contrato [ID=" + id + ", Cliente=" + cliente.getNome() + ", Vendedor=" + vendedor.getNome() + ", Valor=" + valor + "]";
    }
}
