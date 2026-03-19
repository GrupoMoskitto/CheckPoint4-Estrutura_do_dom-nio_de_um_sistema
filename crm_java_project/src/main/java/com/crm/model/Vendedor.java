package com.crm.model;

import com.crm.model.enums.Qualificacao;
import com.crm.model.vo.Endereco;

public class Vendedor {
    private String id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Endereco endereco;
    private Qualificacao qualificacao;

    public Vendedor(String id, String nome, String cpf, String email, String telefone, Endereco endereco, Qualificacao qualificacao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.qualificacao = qualificacao;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public Endereco getEndereco() { return endereco; }
    public Qualificacao getQualificacao() { return qualificacao; }

    @Override
    public String toString() {
        return "Vendedor [ID=" + id + ", Nome=" + nome + ", Qualificação=" + qualificacao + "]";
    }
}
