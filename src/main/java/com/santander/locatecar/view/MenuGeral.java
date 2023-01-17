package br.com.ada.projeto.locadoraveiculos.view;

public class MenuGeral extends MenuComSubmenus {
    public MenuGeral(String descricao) {
        super(descricao);
    }

    @Override
    protected void acao() {
        super.acao();

        this.agir();
    }
}
