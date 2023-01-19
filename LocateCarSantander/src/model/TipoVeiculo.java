package model;


public enum TipoVeiculo {
    MOTO("Moto", 100),
    CARRO("Carro", 150),
    CAMINHAO("Caminhão", 200);

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
}
