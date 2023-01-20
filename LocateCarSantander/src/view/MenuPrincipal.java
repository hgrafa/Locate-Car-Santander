package view;

import java.util.Scanner;

/*
Nessa classe está o menu principal da aplicação, que será dividida em três submenus (cliente, agencia e veículo).
No método iniciar, tem a entrada de dados do usuário e o switch que vai direcionar para o submenu correspondente.
Falta fazer o menu cliente e menu agência.
*/

public class MenuPrincipal {
    private Scanner entrada = new Scanner(System.in);
    private MenuVeiculo menuVeiculo;
    private MenuAgencia menuAgencia;
    private MenuCliente menuCliente;
    private MenuAluguel menuAluguel;


    public MenuPrincipal(){
        this.menuVeiculo = new MenuVeiculo();
        this.menuAgencia = new MenuAgencia();
        this.menuCliente = new MenuCliente();
        this.menuAluguel = new MenuAluguel();

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
                    4 - Menu Aluguel
                    0 - Encerrar Programa
                    """);
        System.out.print(">");
    }

    private void direcionarOpcao(String opcao) {
        switch (opcao) {
            case "1" -> this.menuCliente.iniciar();
            case "2" -> this.menuAgencia.iniciar();
            case "3" -> this.menuVeiculo.iniciar();
            case "4" -> this.menuAluguel.iniciar();
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
