package persistence;

import model.Cliente;
import model.Veiculo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Classe que guarda os dados dos veículos em memória. Precisamos implementar o banco de dados.
Falta fazer o alterar veículo.
 */
public class VeiculosRepository {
    private Map<String,Veiculo> veiculos;

    public VeiculosRepository(){

        this.veiculos = new HashMap<>();
    }

    public void cadastrar(Veiculo veiculo){
        this.veiculos.put(veiculo.getPlaca(),veiculo);
    }

    public List<Veiculo> buscar(String palavraBuscada) {
        return this.veiculos.values().stream()
                .filter(veiculo -> {
                    return veiculo.getModelo().toUpperCase().contains(palavraBuscada.toUpperCase()) ||
                            veiculo.getPlaca().toUpperCase().contains(palavraBuscada.toUpperCase());
                })
                .collect(Collectors.toList());
    }

    public Veiculo buscarPorNumeroDaPlaca(String numeroDaPlaca){
        return this.veiculos.get(numeroDaPlaca);
    }
    public List<Veiculo> listarTodos() {
        return this.veiculos.values().stream().toList();
    }


}
