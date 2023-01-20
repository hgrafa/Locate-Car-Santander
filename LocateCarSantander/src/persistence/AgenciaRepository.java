package persistence;

import model.Agencia;
import model.Endereco;
import model.Veiculo;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class AgenciaRepository {
    private Map<UUID,Agencia> agencia;

    public AgenciaRepository() {
        this.agencia = new HashMap();
    }

    public void cadastrar(Agencia agencia) {
        this.agencia.put(agencia.getId(), agencia);
    }

    public List<Agencia> buscar(String palavraBuscada) {
        return this.agencia.values().stream()
                .filter(agencia -> {
                    return agencia.getNome().toUpperCase().contains(palavraBuscada.toUpperCase());
                })
                .collect(Collectors.toList());
    }

    public Agencia buscaPorEndereco(Endereco endereco){
        return this.agencia.values().stream().filter(agencia -> agencia.getEndereco().equals(endereco)).findFirst().orElse(null);
    }

    public List<Agencia> listarTodos() {
        return this.agencia.values().stream().toList();
    }

    public Agencia buscarPorId(UUID palavraBuscada) {
        return this.agencia.get(palavraBuscada);
    }
}

