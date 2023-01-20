package view;

import controllers.VeiculosController;
import model.TipoCliente;
import model.TipoVeiculo;
import model.Veiculo;

import java.util.List;
import java.util.Scanner;

/*
Similar ao método do menu principal, esse é o submenu Veiculo, onde teremos todas as opções correspondentes às ações do veículo.
No switch aqui não vai direcionar para outro submenu, mas sim para o controler com a ação específica.
Falta implementar o "alterar" veículo.
 */
public class MenuVeiculo {
    private Scanner entrada;
    private VeiculosController controller;

    public MenuVeiculo(){
        this.entrada = new Scanner(System.in);
        this.controller = new VeiculosController();
    }

    private String lerEntrada() {
        return entrada.nextLine();
    }

    private void listarOpcoes(){
        System.out.println("""
                    ####### MENU VEÍCULO #########
                                    
                    Escolha uma opção:
                                    
                    1 - Cadastrar veículo
                    2 - Alterar cadastro do veículo
                    3 - Buscar veículo
                    4 - Listar todos os veículos
                    0 - Voltar ao menu principal
                    """);
        System.out.print(">");
    }

    private void direcionarOpcao(String opcao) {
        switch (opcao) {
            case "1" -> this.cadastrarVeiculo();
            case "2" -> this.alterarVeiculo();
            case "3" -> this.buscarVeiculo();
            case "4" -> this.listarVeiculos();
            default -> {
                if(!opcao.equals("0")) {
                    System.out.println("Opção inválida!\n");
                }
            }
        }
    }

    public void iniciar() {
        String opcao;
        do {
            this.listarOpcoes();
            opcao = this.lerEntrada();
            this.direcionarOpcao(opcao);

        } while (!opcao.equals("0"));
    }


    //
    private void cadastrarVeiculo(){
        System.out.println("Digite a placa:");
        System.out.print(">");
        String placa = this.lerEntrada();
        if(this.controller.buscarPorNumeroDaPlaca(placa)==null){
            TipoVeiculo tipoVeiculo = null;
            do {
                System.out.println("Qual o tipo do veiculo (Moto, Carro ou Caminhão):");
                System.out.print(">");
                String tipo = this.lerEntrada();
                tipoVeiculo = TipoVeiculo.criarTipo(tipo);
            } while (tipoVeiculo == null);
            System.out.println("Digite o modelo:");
            System.out.print(">");
            String modelo = this.lerEntrada();
            this.controller.cadastrar(placa, modelo, tipoVeiculo, true);

            System.out.println("Veículo cadastrado com sucesso!");
        }else {
            System.out.println("IMPOSSÍVEL CADASTRAR: Número da placa já cadastrado!");
        }
    }

    private void alterarVeiculo(){
        System.out.println("Digite a placa do veículo:");
        System.out.print(">");
        String numeroDaPlaca = this.lerEntrada();
        if (this.controller.buscarPorNumeroDaPlaca(numeroDaPlaca)!=null){
            System.out.println("Digite o novo modelo:");
            System.out.print(">");
            String modelo = this.lerEntrada();
            TipoVeiculo tipoVeiculo = null;
            do {
                System.out.println("Qual o novo tipo do veículo? (Moto, Carro ou Caminhão):");
                System.out.print(">");
                String tipo = this.lerEntrada();
                tipoVeiculo = TipoVeiculo.criarTipo(tipo);
            } while (tipoVeiculo == null);
            System.out.println("Veículo ainda está disponível? (Sim/Não)");
            System.out.print(">");
            String disponivelString = this.lerEntrada();
            Boolean disponivel = disponivelString.trim().equalsIgnoreCase("Sim");

            this.controller.cadastrar(numeroDaPlaca,modelo,tipoVeiculo,disponivel);
        }else {
            System.out.println("Número da placa não encontrada!");
        }

    }

    private void buscarVeiculo(){
        System.out.println("Digite um modelo ou uma placa:");
        System.out.print(">");
        String palavraBuscada = this.lerEntrada();
        List<Veiculo> veiculosEncontrados = this.controller.buscar(palavraBuscada);
        if (veiculosEncontrados!=null && !veiculosEncontrados.isEmpty()){
            System.out.println("Veículos encontrados:");
            for (Veiculo veiculo: veiculosEncontrados) {
                System.out.println(veiculo.toString());
            }
        }else {
            System.out.println("NENHUM VEÍCULO ENCONTRADO!");
        }

    }

    private void listarVeiculos(){
        System.out.println("Todos os veículos:");
        List<Veiculo> todosOsVeiculos = this.controller.listarTodos();
        for (Veiculo veiculo: todosOsVeiculos) {
            System.out.println(veiculo.toString());
        }
    }

}
