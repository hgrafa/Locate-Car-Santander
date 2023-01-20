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
    public static TipoCliente criarTipo(String tipo) {
        if ("PessoaFisica".equalsIgnoreCase(tipo) || "Pessoa Física".equalsIgnoreCase(tipo) || "pf".equalsIgnoreCase(tipo)) {
            return TipoCliente.PESSOA_FISICA;
        } else if ("PessoaJuridica".equalsIgnoreCase(tipo) || "Pessoa Jurídica".equalsIgnoreCase(tipo) || "pj".equalsIgnoreCase(tipo)) {
            return TipoCliente.PESSOA_JURIDICA;
        }
        return null;
    }
}
