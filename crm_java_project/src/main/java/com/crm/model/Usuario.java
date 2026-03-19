package com.crm.model;

public class Usuario {
    private String id;
    private String nome;
    private String login;
    private String senha;

    public Usuario(String id, String nome, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getLogin() { return login; }
    public String getSenha() { return senha; }

    @Override
    public String toString() {
        return "Usuario [ID=" + id + ", Nome=" + nome + ", Login=" + login + "]";
    }
}
