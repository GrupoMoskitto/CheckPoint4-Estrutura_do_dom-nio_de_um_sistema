#  CRM - Sistema de Gestão de Relacionamento com o Cliente (Java)

Este projeto é um sistema de CRM completo, desenvolvido em Java, com uma interface interativa via console (menus numerados de 1 a 5+). Ele foi estruturado seguindo os requisitos de canais de acesso, fluxos de atendimento com chatbot e equipe de vendas, além de toda a modelagem de entidades solicitada.

---
##  Feito por: Grupo Moskitto (FIAP - 2ESPA)
- Nome: Gabriel Couto Ribeiro - RM559579
- Nome: Gabriel Kato Peres - RM560000 
- Nome: João Vitor de Matos Araujo - RM559246
- Nome: Marcelo Affonso Fonseca - RM559790

---
##  Arquitetura do Projeto

O sistema utiliza o padrão de separação de responsabilidades para garantir um código limpo e organizado:

| Pacote | Responsabilidade |
| :--- | :--- |
| **`com.crm.model`** | Contém as entidades permanentes (`Vendedor`, `Atendente`, `Cliente`, `Usuario`) e temporárias (`Prospectante`, `Contrato`). |
| **`com.crm.model.enums`** | Define as regras de negócio fixas: `Qualificacao`, `Tipo`, `AreaDeInteresse` e `Status`. |
| **`com.crm.model.vo`** | Implementa o Value Object `Endereco`, utilizado em todos os cadastros que requerem localização. |
| **`com.crm.repository`** | Camada de persistência genérica em memória (RAM), permitindo salvar e buscar dados durante a execução. |
| **`com.crm.service`** | Contém a lógica de negócio, como o gerenciamento do ciclo de vida do prospectante e validações. |
| **`com.crm.ui`** | A **`ConsoleInterface`**, responsável por toda a interação com o usuário através do terminal. |

---

##  Canais de Acesso e Fluxos de Atendimento

O sistema simula a entrada de clientes por diferentes canais:

> **WhatsApp (via Instagram, Facebook ou Web Site):**
> 1. O cliente inicia o contato e é recebido por um **Chatbot treinado**.
> 2. O chatbot esclarece dúvidas iniciais.
> 3. Se houver interesse em orçamento, o sistema encaminha automaticamente para a **Equipe de Vendas** e registra o contato como um **Prospectante**.

> **Chamada Telefônica (via TV, Revistas ou Web Site):**
> 1. O contato é direto e encaminhado imediatamente para a **Equipe de Vendas**.

> **E-mail (via Web Site):**
> 1. O contato é registrado e encaminhado para o **SAC (Serviço de Atendimento ao Cliente)**.

---

##  Como Executar no IntelliJ IDEA

Siga estes passos para rodar o projeto corretamente:

### 1. Preparação
1. Extraia o conteúdo do arquivo `crm_java_project.zip`.
2. Abra o **IntelliJ IDEA**.
3. Vá em `File > Open` e selecione a pasta `crm_java`.

### 2. Configuração do SDK
1. Vá em `File > Project Structure` (ou pressione `Ctrl+Alt+Shift+S`).
2. Em **Project**, certifique-se de que o **Project SDK** está definido para **Java 11, 17 ou 21**.
3. Em **Project language level**, selecione a versão correspondente ao SDK escolhido.

### 3. Configuração das Pastas de Código
1. No painel lateral esquerdo (Project), localize a pasta `src/main/java`.
2. Clique com o botão direito sobre ela.
3. Selecione **Mark Directory as > Sources Root**. (A pasta deve ficar azul).

### 4. Execução
1. Navegue até `src/main/java/com/crm/Main.java`.
2. Clique com o botão direito no arquivo e selecione **Run 'Main.main()'**.
3. O console do IntelliJ abrirá na parte inferior, pronto para receber seus comandos!

---

##  Guia de Uso (Menus)

Ao iniciar, você verá o menu principal:

1. **Canais de Acesso**: Simule a entrada de um novo lead via WhatsApp, Telefone ou E-mail.
2. **Gestão de Entidades**: Cadastre seus Vendedores, Atendentes e Clientes (necessário preencher os dados de Endereço).
3. **Listar Registros**: Veja todos os dados salvos em memória (Vendedores, Clientes, Prospectantes, etc.).
4. **Gerar Novo Contrato**: Vincule um Cliente a um Vendedor e defina o valor do contrato.
0. **Sair**: Encerra o sistema.

---

##  Diferenciais Técnicos
- **Tratamento de Erros**: O sistema não trava se você digitar letras onde deveriam ser números.
- **Identificadores Únicos**: Cada registro recebe um **UUID** automático para garantir que não haja duplicidade de IDs.
- **Value Objects**: O endereço é um objeto imutável, seguindo as melhores práticas de DDD (Domain-Driven Design).
- **Extensibilidade**: O repositório genérico permite que você adicione novas entidades facilmente no futuro.

---
*Desenvolvido com foco em qualidade, organização e facilidade de uso.*
