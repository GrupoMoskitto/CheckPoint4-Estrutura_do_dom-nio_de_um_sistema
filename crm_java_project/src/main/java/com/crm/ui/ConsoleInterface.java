package com.crm.ui;

import com.crm.model.*;
import com.crm.model.enums.*;
import com.crm.model.vo.Endereco;
import com.crm.service.CrmService;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class ConsoleInterface {
    private CrmService service = new CrmService();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n===== CRM - SISTEMA DE GESTÃO =====");
            System.out.println("1. Canais de Acesso e Atendimento");
            System.out.println("2. Gestão de Entidades (Cadastros)");
            System.out.println("3. Listar Registros");
            System.out.println("4. Gerar Novo Contrato");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1: menuCanais(); break;
                    case 2: menuCadastros(); break;
                    case 3: menuListagem(); break;
                    case 4: cadastrarContrato(); break;
                    case 0: System.out.println("Saindo..."); break;
                    default: System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: Entrada inválida.");
            }
        }
    }

    private void menuCanais() {
        System.out.println("\n--- Canais de Acesso e Atendimento ---");
        System.out.println("1. WhatsApp (Instagram, Facebook, Web Site)");
        System.out.println("2. Chamada Telefônica (Anúncios TV, Revistas, Web Site)");
        System.out.println("3. E-mail (Web Site)");
        System.out.print("Escolha o canal: ");
        int canal = Integer.parseInt(scanner.nextLine());

        switch (canal) {
            case 1:
                System.out.println("-> Iniciando Atendimento Inicial com Chatbot treinado...");
                System.out.println("Deseja receber orçamento? (1-Sim / 2-Não)");
                if (scanner.nextLine().equals("1")) {
                    System.out.println("-> Encaminhando para Equipe de Vendas.");
                    prospectar();
                } else {
                    System.out.println("-> Dúvidas esclarecidas pelo Chatbot.");
                }
                break;
            case 2:
                System.out.println("-> Encaminhando para Equipe de Vendas.");
                prospectar();
                break;
            case 3:
                System.out.println("-> Encaminhando para o SAC (Serviço de Atendimento ao Cliente).");
                break;
            default:
                System.out.println("Canal não reconhecido.");
        }
    }

    private void prospectar() {
        System.out.println("\n--- Novo Prospectante ---");
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        System.out.print("Telefone: "); String tel = scanner.nextLine();
        System.out.println("Área de Interesse: 1-Estética / 2-Saúde");
        AreaDeInteresse area = scanner.nextLine().equals("1") ? AreaDeInteresse.ESTETICA : AreaDeInteresse.SAUDE;
        
        Prospectante p = new Prospectante(UUID.randomUUID().toString(), nome, email, tel, area);
        service.cadastrarProspectante(p);
        System.out.println("Prospectante cadastrado com sucesso!");
    }

    private void menuCadastros() {
        System.out.println("\n--- Gestão de Entidades ---");
        System.out.println("1. Cadastrar Vendedor");
        System.out.println("2. Cadastrar Atendente");
        System.out.println("3. Cadastrar Cliente");
        System.out.println("4. Cadastrar Usuário");
        System.out.print("Opção: ");
        int opt = Integer.parseInt(scanner.nextLine());

        switch (opt) {
            case 1: cadastrarVendedor(); break;
            case 2: cadastrarAtendente(); break;
            case 3: cadastrarCliente(); break;
            case 4: cadastrarUsuario(); break;
        }
    }

    private Endereco lerEndereco() {
        System.out.print("Rua: "); String rua = scanner.nextLine();
        System.out.print("Número: "); String num = scanner.nextLine();
        System.out.print("Complemento: "); String comp = scanner.nextLine();
        System.out.print("Bairro: "); String bairro = scanner.nextLine();
        System.out.print("Cidade: "); String cidade = scanner.nextLine();
        System.out.print("UF: "); String uf = scanner.nextLine();
        System.out.print("CEP: "); String cep = scanner.nextLine();
        return new Endereco(rua, num, comp, bairro, cidade, uf, cep);
    }

    private void cadastrarVendedor() {
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("CPF: "); String cpf = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        System.out.print("Telefone: "); String tel = scanner.nextLine();
        Endereco end = lerEndereco();
        System.out.println("Qualificação: 1-Captador / 2-Técnico");
        Qualificacao qual = scanner.nextLine().equals("1") ? Qualificacao.CAPTADOR : Qualificacao.TECNICO;
        
        service.cadastrarVendedor(new Vendedor(UUID.randomUUID().toString(), nome, cpf, email, tel, end, qual));
        System.out.println("Vendedor cadastrado!");
    }

    private void cadastrarAtendente() {
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("CPF: "); String cpf = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        System.out.print("Telefone: "); String tel = scanner.nextLine();
        Endereco end = lerEndereco();
        System.out.println("Tipo: 1-Auxiliar / 2-Técnico / 3-Financeiro");
        int t = Integer.parseInt(scanner.nextLine());
        Tipo tipo = (t == 1) ? Tipo.AUXILIAR : (t == 2) ? Tipo.TECNICO : Tipo.FINANCEIRO;
        
        service.cadastrarAtendente(new Atendente(UUID.randomUUID().toString(), nome, cpf, email, tel, end, tipo));
        System.out.println("Atendente cadastrado!");
    }

    private void cadastrarCliente() {
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("CPF: "); String cpf = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        System.out.print("Telefone: "); String tel = scanner.nextLine();
        Endereco end = lerEndereco();
        System.out.println("Status: 1-Em Atendimento / 2-Concluído / 3-Latente");
        int s = Integer.parseInt(scanner.nextLine());
        Status status = (s == 1) ? Status.EM_ATENDIMENTO : (s == 2) ? Status.CONCLUIDO : Status.LATENTE;
        
        service.cadastrarCliente(new Cliente(UUID.randomUUID().toString(), nome, cpf, email, tel, end, status));
        System.out.println("Cliente cadastrado!");
    }

    private void cadastrarUsuario() {
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("Login: "); String login = scanner.nextLine();
        System.out.print("Senha: "); String senha = scanner.nextLine();
        service.cadastrarUsuario(new Usuario(UUID.randomUUID().toString(), nome, login, senha));
        System.out.println("Usuário cadastrado!");
    }

    private void cadastrarContrato() {
        if (service.listarClientes().isEmpty() || service.listarVendedores().isEmpty()) {
            System.out.println("Erro: Necessário ter pelo menos um cliente e um vendedor cadastrados.");
            return;
        }
        System.out.println("Selecione o Cliente (índice):");
        for (int i = 0; i < service.listarClientes().size(); i++) {
            System.out.println(i + " - " + service.listarClientes().get(i).getNome());
        }
        int cliIdx = Integer.parseInt(scanner.nextLine());
        
        System.out.println("Selecione o Vendedor (índice):");
        for (int i = 0; i < service.listarVendedores().size(); i++) {
            System.out.println(i + " - " + service.listarVendedores().get(i).getNome());
        }
        int venIdx = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Valor do Contrato: ");
        double valor = Double.parseDouble(scanner.nextLine());
        
        Contrato c = new Contrato(UUID.randomUUID().toString(), 
                                 service.listarClientes().get(cliIdx), 
                                 service.listarVendedores().get(venIdx), 
                                 LocalDate.now(), valor);
        service.cadastrarContrato(c);
        System.out.println("Contrato gerado com sucesso!");
    }

    private void menuListagem() {
        System.out.println("\n--- Listagem ---");
        System.out.println("1. Vendedores");
        System.out.println("2. Atendentes");
        System.out.println("3. Prospectantes");
        System.out.println("4. Clientes");
        System.out.println("5. Usuários");
        System.out.println("6. Contratos");
        System.out.print("Opção: ");
        int opt = Integer.parseInt(scanner.nextLine());

        switch (opt) {
            case 1: service.listarVendedores().forEach(System.out::println); break;
            case 2: service.listarAtendentes().forEach(System.out::println); break;
            case 3: service.listarProspectantes().forEach(System.out::println); break;
            case 4: service.listarClientes().forEach(System.out::println); break;
            case 5: service.listarUsuarios().forEach(System.out::println); break;
            case 6: service.listarContratos().forEach(System.out::println); break;
        }
    }
}
