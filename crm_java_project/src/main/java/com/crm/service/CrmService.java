package com.crm.service;

import com.crm.model.*;
import com.crm.repository.Repository;
import java.util.List;

public class CrmService {
    private Repository<Vendedor> vendedorRepo = new Repository<>();
    private Repository<Atendente> atendenteRepo = new Repository<>();
    private Repository<Prospectante> prospectanteRepo = new Repository<>();
    private Repository<Cliente> clienteRepo = new Repository<>();
    private Repository<Usuario> usuarioRepo = new Repository<>();
    private Repository<Contrato> contratoRepo = new Repository<>();

    public void cadastrarVendedor(Vendedor v) { vendedorRepo.save(v); }
    public List<Vendedor> listarVendedores() { return vendedorRepo.findAll(); }

    public void cadastrarAtendente(Atendente a) { atendenteRepo.save(a); }
    public List<Atendente> listarAtendentes() { return atendenteRepo.findAll(); }

    public void cadastrarProspectante(Prospectante p) { prospectanteRepo.save(p); }
    public List<Prospectante> listarProspectantes() { return prospectanteRepo.findAll(); }
    public void removerProspectante(Prospectante p) { prospectanteRepo.remove(p); }

    public void cadastrarCliente(Cliente c) { clienteRepo.save(c); }
    public List<Cliente> listarClientes() { return clienteRepo.findAll(); }

    public void cadastrarUsuario(Usuario u) { usuarioRepo.save(u); }
    public List<Usuario> listarUsuarios() { return usuarioRepo.findAll(); }

    public void cadastrarContrato(Contrato c) { contratoRepo.save(c); }
    public List<Contrato> listarContratos() { return contratoRepo.findAll(); }
}
