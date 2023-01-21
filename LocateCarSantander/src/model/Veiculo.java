package model;

public class Veiculo {
    private String placa;
    private String modelo;
    private TipoVeiculo tipo;
    private boolean disponivel;
    private Agencia agenciaRetirada;
    private Agencia agenciaDevolucao;

    //construtor veículo
    public Veiculo(String placa, String modelo, TipoVeiculo tipo, Boolean disponivel, Agencia agenciaRetirada, Agencia agenciaDevolucao) {
        this.placa = placa;
        this.modelo = modelo;
        this.tipo = tipo;
        this.disponivel = disponivel;
        this.agenciaRetirada = agenciaRetirada;
        this.agenciaDevolucao = agenciaDevolucao;
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

    public String getAgenciaRetirada(){
        return agenciaRetirada.getNome();
    }

    public String getAgenciaDevolucao(){
        return agenciaDevolucao.getNome();
    }

    public float getPreco(){
        return tipo.getPreco();
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




