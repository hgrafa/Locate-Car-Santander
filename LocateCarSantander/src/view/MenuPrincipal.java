package view;

import java.util.Scanner;

/*
Nesse classe está o menu principal da aplicação, que será dividida em três submenus (cliente, agencia e veículo).
No método iniciar, tem a entrada de dados do usuário e o switch que vai direcionar para o submenu correspondente.
*/

public class MenuPrincipal {
    private Scanner entrada = new Scanner(System.in);
    private MenuVeiculo menuVeiculo;

    public MenuPrincipal(){
        this.menuVeiculo = new MenuVeiculo();
    }
    private String obterOpcao() {
        return entrada.nextLine();
    }
    private void listarOpcoes(){
        System.out.println("""
                    ####### LOCADORA DE VEÍCULOS #########
                                    
                    Escolha uma opção:
                                    
                    1 - Menu Cliente
                    2 - Menu Agência
                    3 - Menu Veículo
                    0 - Encerrar Programa
                    """);
        System.out.print(">");
    }

    private void direcionarOpcao(String opcao) {
        switch (opcao) {
            case "1" -> this.menuVeiculo.iniciar(); //menu Cliente (alterar)
            case "2" -> this.menuVeiculo.iniciar(); //menu Agência (alterar)
            case "3" -> this.menuVeiculo.iniciar();
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
            opcao = this.obterOpcao();
            this.direcionarOpcao(opcao);
        } while (!opcao.equals("0"));
    }
}
