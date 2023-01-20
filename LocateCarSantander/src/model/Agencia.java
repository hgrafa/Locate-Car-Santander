package model;

import java.util.UUID;

public class Agencia {
    private String nome;
    private Endereco endereco;
    private UUID id;


    public Agencia(String nome, Endereco endereco) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.endereco = endereco;
    }
    public Agencia(UUID id, String nome, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public UUID getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "nome='" + nome + '\'' +
                ", endereco=" + endereco +'\'' +
                ", \t id = " + id +
                '}';
    }
}
