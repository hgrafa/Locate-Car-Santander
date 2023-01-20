package model;

import java.util.UUID;

public class Agencia {
    private String nome;
    private String endereco;
    private UUID id;


    public Agencia(String nome, String endereco) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.endereco = endereco;
    }
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "nome='" + nome + '\'' +
                ", logradouro='" + endereco + '\'' +
                '}';
    }
}
