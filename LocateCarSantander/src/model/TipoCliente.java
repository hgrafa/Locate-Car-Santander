package model;


public enum TipoCliente {

    PESSOA_FISICA("Pessoa Física", 5),
    PESSOA_JURIDICA("Pessoa Jurídica", 10);


    private String tipo;
    private int desconto;

    private TipoCliente(String tipo, int desconto){
        this.tipo = tipo;
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return "TipoCliente{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
