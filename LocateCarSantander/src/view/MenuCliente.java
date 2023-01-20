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
        System.out.println("Digite o parte do documento ou parte do nome do cliente");
        System.out.print(">");
        String palavraBuscada = this.lerEntrada();
        List<Cliente> clientesEncontrado = this.controller.buscar(palavraBuscada);
        if( clientesEncontrado !=null && !clientesEncontrado.isEmpty()){
            System.out.println("Cliente(s) encontrado(s):");
            for (Cliente cliente: clientesEncontrado){
                System.out.println(cliente.toString());
            }
        }else {
            System.out.println("NENHUM CLIENTE ENCONTRADO!");
        }
    }

    private void alterarCliente() {
        System.out.println("Digite o número exato do documento do cliente:");
        System.out.print(">");
        String numeroDoDoucmento = this.lerEntrada();
        if (this.controller.buscarPorDocumentoExato(numeroDoDoucmento)!=null){
            System.out.println("Digite o novo nome:");
            System.out.print(">");
            String nome = this.lerEntrada();
            TipoCliente tipoCliente = null;
            do {
                System.out.println("Qual o novo tipo do cliente? (Pessoa Física ou Pessoa Jurídica):");
                System.out.print(">");
                String tipo = this.lerEntrada();
                tipoCliente = TipoCliente.criarTipo(tipo);
            } while (tipoCliente == null);

            this.controller.cadastrar(nome, numeroDoDoucmento, tipoCliente);
        }else {
            System.out.println("Número do docuemnto não encontrado!");
        }

    }

    private void cadastrarCliente(){
        System.out.println("Digite nome:");
        System.out.print(">");
        String nome = this.lerEntrada();
        System.out.println("Digite o documento:");
        System.out.print(">");
        String documento = this.lerEntrada();
        if (this.controller.buscarPorDocumentoExato(documento)==null){
            TipoCliente tipoCliente = null;
            do {
                System.out.println("Qual o tipo do cliente? (Pessoa Física ou Pessoa Jurídica):");
                System.out.print(">");
                String tipo = this.lerEntrada();
                tipoCliente = TipoCliente.criarTipo(tipo);
            } while (tipoCliente == null);

            this.controller.cadastrar(nome, documento, tipoCliente);

            System.out.println("Cliente cadastrado com sucesso!");
        }else{
            System.out.println("IMPOSSÍVEL CADASTRAR: Número do doucmento de cleinte já cadastrado!");
        }


    }

}
