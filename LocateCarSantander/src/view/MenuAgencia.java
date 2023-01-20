package view;

import controllers.AgenciaController;
import controllers.VeiculosController;
import model.*;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

public class MenuAgencia {

    private Scanner entrada;
    private AgenciaController controller;

    public MenuAgencia() {
        this.entrada = new Scanner(System.in);
        this.controller = new AgenciaController();
    }

    private String lerEntrada(String menssagem) {
        System.out.println(menssagem);
        System.out.print(">");
        return entrada.nextLine();
    }

    private void listarOpcoes() {
        System.out.println("""
                ####### MENU AGÊNCIA #########
                                
                Escolha uma opção:
                                
                1 - Cadastrar agência
                2 - Alterar cadastro da agência
                3 - Buscar agência
                4 - Listar agências cadastradas
                0 - Voltar ao menu principal
                """);
        System.out.print(">");
    }

    private void direcionarOpcao(String opcao) {
        switch (opcao) {
            case "1" -> this.cadastrarAgencia();
            case "2" -> this.alterarAgencia();
            case "3" -> this.buscarAgencia();
            case "4" -> this.listarAgencias();
            default -> {
                if (!opcao.equals("0")) {
                    System.out.println("Opção inválida!\n");
                }
            }
        }
    }
    public void iniciar() {
        String opcao;
        do {
            this.listarOpcoes();
            opcao = this.lerEntrada("");
            this.direcionarOpcao(opcao);

        } while (!opcao.equals("0"));
    }

    private void cadastrarAgencia() {
        String nome = this.lerEntrada("Digite o nome da agência:");
        Endereco endereco = this.cadastrarEndereco();
        if(this.controller.buscaPorEndereco(endereco)==null){
            this.controller.cadastrar(nome, endereco);
            System.out.println("Agência cadastrada com sucesso!");
        }else {
            System.out.println("IMPOSSÍVEL CADASTRAR: Endereço já cadastrado em outra agência!");
        }
    }

    private Endereco cadastrarEndereco(){
        System.out.println("Digite os dados e endereço da agência");
        String logradouro = this.lerEntrada("Logradouro");
        String bairro = this.lerEntrada("Bairro");
        String numero = this.lerEntrada("Número");
        String complemento = this.lerEntrada("Complemento");
        String cep = this.lerEntrada("CEP");
        String cidade = this.lerEntrada("Cidade");
        String estado = this.lerEntrada("UF");

        Endereco endereco = new Endereco(logradouro, bairro, cep,
                numero, complemento, cidade, estado);

        return endereco;

    }

    private void alterarAgencia() {
        this.listarAgencias();
        String id = this.lerEntrada("Digite o id da agência");
        if (this.controller.buscarPorId(UUID.fromString(id))!=null){
            String nome = this.lerEntrada("Digite o novo nome:");
            String alteraEndereco = this.lerEntrada("Deseja alterar o endereço? (Sim/Não)");
            if(alteraEndereco.trim().equalsIgnoreCase("sim")){
                System.out.println("Digite o novo endereço");
                Endereco endereco = this.cadastrarEndereco();
                this.controller.alterarAgencia(UUID.fromString(id),nome, endereco);
            }else{
                this.controller.alterarAgencia(UUID.fromString(id),nome,this.controller.buscarPorId(UUID.fromString(id)).getEndereco());
            }
        }else {
            System.out.println("Número da placa não encontrada!");
        }
    }

    private void buscarAgencia() {
        String palavraBuscada = this.lerEntrada("Digite o nome de uma agência:");


        List<Agencia> agenciasEncontradas = this.controller.buscar(palavraBuscada);
        if(agenciasEncontradas!=null && !agenciasEncontradas.isEmpty()){
            System.out.println("Agências encontradas:");
            for (Agencia agencia : agenciasEncontradas) {
                System.out.println(agencia.toString());
            }
        }else{
            System.out.println("NENHUMA AGÊNCIA ENCONTRADA!");
        }

    }
    private void listarAgencias() {
        System.out.println("Todos as agências:");
        List<Agencia> todasAgencias = this.controller.listarTodos();
        for (Agencia agencia: todasAgencias) {
            System.out.println(agencia.toString());
        }
    }


}
