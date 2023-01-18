package com.santander.locatecar;

import com.santander.locatecar.business.GerenciadorDeAgencia;
import com.santander.locatecar.model.Agencia;
import com.santander.locatecar.persistence.AgenciaEmMemoriaRepository;
import com.santander.locatecar.persistence.AgenciaRepository;
import com.santander.locatecar.view.Menu;
import com.santander.locatecar.view.MenuGeralFactory;
import com.santander.locatecar.view.agencia.MenuAgenciasFactory;

public class Main {
    public static void main(String[] args) {

        AgenciaRepository agenciaRepository = new AgenciaEmMemoriaRepository();

        GerenciadorDeAgencia gerenciadorDeAgencia = new GerenciadorDeAgencia(agenciaRepository);
        Agencia agencia = gerenciadorDeAgencia.criarAgencia("AG1", "Maringá");
//        System.out.println("Nova agência criada");
//        System.out.println(agencia);

        MenuAgenciasFactory menuAgenciasFactory = new MenuAgenciasFactory(gerenciadorDeAgencia);
        Menu menuGeral = new MenuGeralFactory(menuAgenciasFactory).create();
        menuGeral.agir();

    }
}