package com.crm.model;

import com.crm.model.enums.Status;
import com.crm.model.vo.Endereco;

public class Cliente {
    private String id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Endereco endereco;
    private Status status;

    public Cliente(String id, String nome, String cpf, String email, String telefone, Endereco endereco, Status status) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.status = status;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public Endereco getEndereco() { return endereco; }
    public Status getStatus() { return status; }

    @Override
    public String toString() {
        return "Cliente [ID=" + id + ", Nome=" + nome + ", Status=" + status + "]";
    }
}
