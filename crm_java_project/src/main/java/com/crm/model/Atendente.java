package com.crm.model;

import com.crm.model.enums.Tipo;
import com.crm.model.vo.Endereco;

public class Atendente {
    private String id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Endereco endereco;
    private Tipo tipo;

    public Atendente(String id, String nome, String cpf, String email, String telefone, Endereco endereco, Tipo tipo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.tipo = tipo;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public Endereco getEndereco() { return endereco; }
    public Tipo getTipo() { return tipo; }

    @Override
    public String toString() {
        return "Atendente [ID=" + id + ", Nome=" + nome + ", Tipo=" + tipo + "]";
    }
}
