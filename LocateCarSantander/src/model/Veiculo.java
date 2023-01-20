package model;

public class Veiculo {
    private String placa;
    private String modelo;
    private TipoVeiculo tipo;
    private boolean disponivel;

    //construtor veículo
    public Veiculo(String placa, String modelo, TipoVeiculo tipo, Boolean disponivel) {
        this.placa = placa;
        this.modelo = modelo;
        this.tipo = tipo;
        this.disponivel = disponivel;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tipo=" + tipo +
                ", disponivel=" + disponivel +
                '}';
    }
}




