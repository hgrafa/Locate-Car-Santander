package view;

import controllers.AgenciaController;
import controllers.VeiculosController;
import model.Agencia;
import model.TipoVeiculo;
import model.Veiculo;

import java.util.List;
import java.util.Scanner;

public class MenuAgencia {
    private Scanner entrada;
    private AgenciaController controller;

    public MenuAgencia() {
        this.entrada = new Scanner(System.in);
        this.controller = new AgenciaController();
    }

    private String lerEntrada() {
        return entrada.nextLine();
    }

    private void listarOpcoes() {
        System.out.println("""
                ####### MENU AGÊNCIA #########
                                
                Escolha uma opção:
                                
                1 - Cadastrar agência
                2 - Alterar cadastro da agência
                3 - Buscar agência
                4 - Alugar veículo (pessoa física)
                5 - Devolver veículo (pessoa física)
                6 - Alugar veículo (pessoa jurídica)
                7 - Devolver veículo (pessoa jurídica)
                8 - Gerar um comprovante com todos os dados do aluguel
                9 - Gerar um comprovante com todos os dados da devolução
                0 - Voltar ao menu principal
                """);
        System.out.print(">");
    }

    private void direcionarOpcao(String opcao) {
        switch (opcao) {
            case "1" -> this.cadastrarAgencia();
            case "2" -> this.alterarAgencia();
            case "3" -> this.buscarAgencia();
            case "4" -> this.alugarVeiculoPF();
            case "5" -> this.devolverVeiculoPF();
            case "6" -> this.alugarVeiculoPJ();
            case "7" -> this.devolverVeiculoPJ();
            case "8" -> this.comprovanteAluguel();
            case "9" -> this.comprovanteDevolucao();
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
            opcao = this.lerEntrada();
            this.direcionarOpcao(opcao);

        } while (!opcao.equals("0"));
    }

    private void cadastrarAgencia() {
        System.out.println("Digite o nome da agência:");
        System.out.print(">");
        String nome = this.lerEntrada();
        System.out.println("Digite o endereço da agência:");
        System.out.print(">");
        String endereco = this.lerEntrada();

        this.controller.cadastrar(nome, endereco);

        System.out.println("Agência cadastrada com sucesso!");
    }

    private void alterarAgencia() {
        System.out.println("Chamar AgenciaController.alterar"); //alterar!
    }

    private void buscarAgencia() {
        System.out.println("Digite o nome de uma agência:");
        System.out.print(">");
        String palavraBuscada = this.lerEntrada();

        System.out.println("Agências encontradas:");
        List<Agencia> agenciasEncontradas = this.controller.buscar(palavraBuscada);
        for (Agencia agencia : agenciasEncontradas) {
            System.out.println(agencia.toString());
        }
    }
    private void comprovanteDevolucao() {
    }

    private void comprovanteAluguel() {
    }

    private void devolverVeiculoPJ() {
    }

    private void alugarVeiculoPJ() {
    }

    private void devolverVeiculoPF() {
    }

    private void alugarVeiculoPF() {
    }

}
