package view;

import controllers.AgenciaController;
import controllers.AluguelController;

import java.util.Scanner;

public class MenuAluguel {

    private Scanner entrada;
    private AluguelController controller;

    public MenuAluguel() {
        this.entrada = new Scanner(System.in);
        this.controller = new AluguelController();
    }
    private String lerEntrada(String menssagem) {
        System.out.println(menssagem);
        System.out.print(">");
        return entrada.nextLine();
    }

    private void direcionarOpcao(String opcao) {
        switch (opcao) {
            case "1" -> this.alugarVeiculo();
            case "2" -> this.alterarUmAluguel();
            case "3" -> this.gerarHistoricoAlugueis();
            default -> {
                if (!opcao.equals("0")) {
                    System.out.println("Opção inválida!\n");
                }
            }
        }
    }

    private void gerarHistoricoAlugueis() {
    }

    private void alterarUmAluguel() {
    }

    private void alugarVeiculo() {
    }

    public void iniciar() {
        String opcao;
        do {
            this.listarOpcoes();
            opcao = this.lerEntrada("");
            this.direcionarOpcao(opcao);

        } while (!opcao.equals("0"));
    }


    private void listarOpcoes() {
        System.out.println("""
                ####### MENU ALUGUEL #########
                                
                Escolha uma opção:
                                
                1 - Alugar veículo
                2 - Alterar um contrato de aluguel (local de devolução e duração)
                3 - Gerar histórico de alugéis
                0 - Voltar ao menu principal
                """);
        System.out.print(">");
    }

}
