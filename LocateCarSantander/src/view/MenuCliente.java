package view;

import controllers.ClienteController;
import model.Cliente;
import model.TipoCliente;


import java.util.List;
import java.util.Scanner;

public class MenuCliente {

    private Scanner entrada;
    private ClienteController controller;

    public MenuCliente(){
        this.entrada = new Scanner(System.in);
        this.controller = new ClienteController();
    }

    private String lerEntrada() {
        return entrada.nextLine();
    }

    public void iniciar() {
        String opcao;
        do {
            this.listarOpcoes();
            opcao = this.lerEntrada();
            this.direcionarOpcao(opcao);

        } while (!opcao.equals("0"));
    }

    private void listarOpcoes() {
        System.out.println("""
                    ####### MENU CLIENTE #########
                                    
                    Escolha uma opção:
                                    
                    1 - Cadastrar cliente
                    2 - Alterar cadastro do cliente
                    3 - Buscar cliente
                    4 - Listar todos os clientes
                    0 - Voltar ao menu principal
                    """);
        System.out.print(">");
    }
    private void direcionarOpcao(String opcao) {
        switch (opcao) {
            case "1" -> this.cadastrarCliente();
            case "2" -> this.alterarCliente();
            case "3" -> this.buscarCliente();
            case "4" -> this.listarClientes();
            default -> {
                if(!opcao.equals("0")) {
                    System.out.println("Opção inválida!\n");
                }
            }
        }
    }

    private void listarClientes() {
        System.out.println("Todos os Clientes:");
        List<Cliente> todosOsClientes = this.controller.listarTodos();
        for(Cliente cliente: todosOsClientes) {
            System.out.println(cliente.toString());
        }
    }

    private void buscarCliente() {
        System.out.println("Digite o documento do cliente");
        System.out.print(">");
        String palavraBuscada = this.lerEntrada();

        System.out.println("Cliente encontrado:");
        List<Cliente> clientesEncontrado = this.controller.buscar(palavraBuscada);
        for (Cliente cliente: clientesEncontrado){
            System.out.println(cliente.toString());
        }

    }

    private void alterarCliente() {

    }

    private void cadastrarCliente(){
        System.out.println("Digite nome:");
        System.out.print(">");
        String nome = this.lerEntrada();
        System.out.println("Digite o documento:");
        System.out.print(">");
        String documento = this.lerEntrada();

        TipoCliente tipoCliente = null;
        do {
            System.out.println("Qual o tipo do cliente? (Pessoa Física ou Pessoa Jurídica):");
            System.out.print(">");
            String tipo = this.lerEntrada();
            tipoCliente = TipoCliente.criarTipo(tipo);
        } while (tipoCliente == null);

        this.controller.cadastrar(nome, documento, tipoCliente);

        System.out.println("Cliente cadastrado com sucesso!");
    }

}
