package model;


public enum TipoVeiculo {
    MOTO("Moto", 100.00f),
    CARRO("Carro", 150.00f),
    CAMINHAO("Caminhão", 200.00f);

    private String nome;
    private float preco;

    private TipoVeiculo(String nome, float preco){
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "TipoVeiculo{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

    public static TipoVeiculo criarTipo(String tipo) {
        if ("Moto".equalsIgnoreCase(tipo)) {
            return TipoVeiculo.MOTO;
        } else if ("Carro".equalsIgnoreCase(tipo)) {
            return TipoVeiculo.CARRO;
        } else if ("Caminhão".equalsIgnoreCase(tipo) || "Caminhao".equalsIgnoreCase(tipo)) {
            return TipoVeiculo.CAMINHAO;
        }
        return null;
    }
}
