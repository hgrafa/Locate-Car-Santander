package view;

import java.util.Scanner;

/*
Similar ao método do menu principal, esse é o submenu Veiculo, onde teremos todas as opções correspondentes às ações do veículo.
No switch aqui não vai direcionar para outro submenu, mas sim para o controler com a ação específica.
 */
public class MenuVeiculo {
    private Scanner entrada = new Scanner(System.in);

    private String obterOpcao() {
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
            opcao = this.obterOpcao();
            this.direcionarOpcao(opcao);

        } while (!opcao.equals("0"));
    }

    private void cadastrarVeiculo(){
        System.out.println("Chamar VeiculoController.cadastrar");
    }

    private void alterarVeiculo(){
        System.out.println("Chamar VeiculoController.alterar");
    }

    private void buscarVeiculo(){
        System.out.println("Chamar VeiculoController.buscar");
    }

    private void listarVeiculos(){
        System.out.println("Chamar VeiculoController.listar");
    }

}
