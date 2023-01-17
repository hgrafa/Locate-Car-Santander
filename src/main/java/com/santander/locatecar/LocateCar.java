package br.com.ada.projeto.locadoraveiculos;

import br.com.ada.projeto.locadoraveiculos.business.GerenciadorDeAgencia;
import br.com.ada.projeto.locadoraveiculos.model.Agencia;
import br.com.ada.projeto.locadoraveiculos.persistence.AgenciaEmMemoriaRepository;
import br.com.ada.projeto.locadoraveiculos.persistence.AgenciaRepository;
import br.com.ada.projeto.locadoraveiculos.view.Menu;
import br.com.ada.projeto.locadoraveiculos.view.MenuGeralFactory;
import br.com.ada.projeto.locadoraveiculos.view.agencia.MenuAgenciasFactory;

public class LocateCar {

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
