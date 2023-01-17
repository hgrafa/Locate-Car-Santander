package br.com.ada.projeto.locadoraveiculos.view.agencia;

import br.com.ada.projeto.locadoraveiculos.business.GerenciadorDeAgencia;
import br.com.ada.projeto.locadoraveiculos.view.Menu;
import br.com.ada.projeto.locadoraveiculos.view.MenuComSubmenus;
import br.com.ada.projeto.locadoraveiculos.view.MenuFactory;

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
