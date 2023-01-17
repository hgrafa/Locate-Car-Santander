package br.com.ada.projeto.locadoraveiculos.model;

public class Cliente implements Entidade {

    private String nome;

    private String documento;

    private TipoCliente tipoCliente;

    public Cliente(String nome, String documento, TipoCliente tipoCliente) {
        this.nome = nome;
        this.documento = documento;
        this.tipoCliente = tipoCliente;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String getId() {
        return documento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", tipoCliente=" + tipoCliente +
                '}';
    }
}
