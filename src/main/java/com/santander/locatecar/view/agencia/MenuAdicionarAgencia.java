package com.santander.locatecar.view.agencia;

import com.santander.locatecar.business.GerenciadorDeAgencia;
import com.santander.locatecar.model.Agencia;
import com.santander.locatecar.view.CapturadorDeEntrada;
import com.santander.locatecar.view.MenuAbstrato;

public class MenuAdicionarAgencia extends MenuAbstrato {

    private final GerenciadorDeAgencia gerenciadorDeAgencia;
    public MenuAdicionarAgencia(GerenciadorDeAgencia gerenciadorDeAgencia) {
        super("Adicionar agencia");
        this.gerenciadorDeAgencia = gerenciadorDeAgencia;
    }

    @Override
    public void acao() {
        String nome = CapturadorDeEntrada.capturarString("nome da nova agencia");

        while (gerenciadorDeAgencia.existeAgencia(nome)) {
            System.out.println("Já existe uma agencia com o nome " + nome);
            nome = CapturadorDeEntrada.capturarString("nome da nova agencia");
        }
        String logradouro = CapturadorDeEntrada.capturarString("logradouro da nova agencia");
        Agencia agencia = gerenciadorDeAgencia.criarAgencia(nome, logradouro);

        System.out.println("Agencia adicionada com sucesso");
        System.out.println("Nova Agencia:");
        System.out.println(agencia);


    }
}
