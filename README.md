# Sistema de Gerenciamento de Restaurante

Este projeto é um sistema de gerenciamento de restaurante desenvolvido em Java utilizando a biblioteca Swing para a interface gráfica. Ele permite o cadastro de clientes, funcionários, pratos e pedidos, além de fornecer funcionalidades como histórico de pedidos e seleção de funcionários e clientes para novos pedidos.

---

## Funcionalidades

1. **Cadastro de Clientes**:
   - Cadastro de informações: nome, telefone e endereço.

2. **Cadastro de Funcionários**:
   - Cadastro de informações: nome, cargo e salário.

3. **Cadastro de Pratos**:
   - Cadastro de pratos com nome, preço e categoria (entrada, prato principal, sobremesa).

4. **Novo Pedido**:
   - Criação de novos pedidos com seleção de pratos, quantidade, observações e tipo de pedido (entrega ou comer no local).
   - Antes de criar um novo pedido, o sistema solicita a seleção de um funcionário e um cliente.
   - Associação de pedidos a um cliente e um funcionário.

5. **Histórico de Pedidos**:
   - Visualização de todos os pedidos realizados, com detalhes como prato, quantidade, observação, tipo de pedido e cliente.

---

## Estrutura do Projeto

O projeto é composto pelas seguintes classes principais:

- **JanelaB**: Tela principal do sistema, com menus para acessar todas as funcionalidades.
- **CadastroClientes**: Tela para cadastro de clientes.
- **CadastroFuncionarios**: Tela para cadastro de funcionários.
- **CadastroPratos**: Tela para cadastro de pratos.
- **NovoPedido**: Tela para criação de novos pedidos.
- **SelecionarFuncionarioCliente**: Tela para seleção de funcionário e cliente antes de criar um pedido.
- **HistoricoPedidos**: Tela para visualização do histórico de pedidos.
- **Pedido**: Classe que representa um pedido, com atributos como prato, quantidade, observação, tipo de pedido, cliente e funcionário.
- **Cliente**: Classe que representa um cliente, com atributos como nome, telefone e endereço.
- **Funcionario**: Classe que representa um funcionário, com atributos como nome, cargo e salário.
- **Prato**: Classe que representa um prato, com atributos como nome, preço e categoria.
