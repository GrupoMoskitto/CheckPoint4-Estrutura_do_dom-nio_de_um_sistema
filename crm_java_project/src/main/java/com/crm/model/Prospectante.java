package com.crm.model;

import com.crm.model.enums.AreaDeInteresse;

public class Prospectante {
    private String id;
    private String nome;
    private String email;
    private String telefone;
    private AreaDeInteresse areaDeInteresse;

    public Prospectante(String id, String nome, String email, String telefone, AreaDeInteresse areaDeInteresse) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.areaDeInteresse = areaDeInteresse;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public AreaDeInteresse getAreaDeInteresse() { return areaDeInteresse; }

    @Override
    public String toString() {
        return "Prospectante [ID=" + id + ", Nome=" + nome + ", Área de Interesse=" + areaDeInteresse + "]";
    }
}
