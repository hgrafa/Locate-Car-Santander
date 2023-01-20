package model;


    import java.util.Objects;

public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    private Endereco() {
    }

    public Endereco(String logradouro, String bairro, String cep, String numero, String complemento, String cidade, String uf) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
    }


    @Override
    public String toString() {
        return String.format(
                        ", Logradouro: %s" +
                        ", Número: %s" +
                        ", Bairro: %s" +
                        ", Complemento: %s" +
                        ", Cidade: %s" +
                        ", CEP: %s" +
                        ", UF: %s \n",
                logradouro, numero, bairro, complemento, cidade, cep, uf)
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(logradouro, endereco.logradouro) && Objects.equals(bairro, endereco.bairro) && Objects.equals(cep, endereco.cep) && Objects.equals(numero, endereco.numero) && Objects.equals(cidade, endereco.cidade) && Objects.equals(uf, endereco.uf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logradouro, bairro, cep, numero, cidade, uf);
    }
}

