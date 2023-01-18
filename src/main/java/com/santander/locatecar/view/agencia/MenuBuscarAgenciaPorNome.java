package com.santander.locatecar.view.agencia;

import com.santander.locatecar.business.GerenciadorDeAgencia;
import com.santander.locatecar.model.Agencia;
import com.santander.locatecar.view.CapturadorDeEntrada;
import com.santander.locatecar.view.MenuAbstrato;

public class MenuBuscarAgenciaPorNome extends MenuAbstrato {

    private final GerenciadorDeAgencia gerenciadorDeAgencia;
    public MenuBuscarAgenciaPorNome(GerenciadorDeAgencia gerenciadorDeAgencia) {
        super("Buscar agencia por nome");
        this.gerenciadorDeAgencia = gerenciadorDeAgencia;
    }

    @Override
    public void acao() {
        String nome = CapturadorDeEntrada.capturarString("nome da agencia buscada");

        if (!gerenciadorDeAgencia.existeAgencia(nome)) {
            System.out.println("Não existe agencia com o nome " + nome);
            return;
        }

        Agencia agencia = gerenciadorDeAgencia.buscarAgenciaPorNome(nome);
        System.out.println("Agencia encontrada:");
        System.out.println(agencia);

    }
}
