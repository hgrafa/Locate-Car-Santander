package com.santander.locatecar.view.agencia;

import com.santander.locatecar.business.GerenciadorDeAgencia;
import com.santander.locatecar.view.Menu;
import com.santander.locatecar.view.MenuComSubmenus;
import com.santander.locatecar.view.MenuFactory;

public class MenuAgenciasFactory implements MenuFactory {

    private final GerenciadorDeAgencia gerenciadorDeAgencia;

    public MenuAgenciasFactory(GerenciadorDeAgencia gerenciadorDeAgencia) {
        this.gerenciadorDeAgencia = gerenciadorDeAgencia;
    }

    @Override
    public Menu create() {
        MenuComSubmenus menuAgencias = new MenuComSubmenus("Menu Agencias");

        Menu menuAdicionarAgencia = new MenuAdicionarAgencia(gerenciadorDeAgencia);
        menuAgencias.adicionarSubmenu(menuAdicionarAgencia);

        Menu menuBuscarAgenciaPorNome = new MenuBuscarAgenciaPorNome(gerenciadorDeAgencia);
        menuAgencias.adicionarSubmenu(menuBuscarAgenciaPorNome);

        return menuAgencias;
    }
}

