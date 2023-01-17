package br.com.ada.projeto.locadoraveiculos.view;

import java.util.Scanner;

public class CapturadorDeEntrada {

    private static final Scanner scanner = new Scanner(System.in);

    public static String capturarString(String nomeCampo) {
        System.out.print("Informar o %s: ".formatted(nomeCampo));
        String entrada = scanner.nextLine();
        return entrada;
    }
}
