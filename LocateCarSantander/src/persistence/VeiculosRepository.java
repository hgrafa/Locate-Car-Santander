package persistence;

import model.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
Classe que guarda os dados dos veículos em memória. Precisamos implementar o banco de dados.
Falta fazer o alterar veículo.
 */
public class VeiculosRepository {
    private List<Veiculo> veiculos;

    public VeiculosRepository(){
        this.veiculos = new ArrayList<Veiculo>();
    }

    public void cadastrar(Veiculo veiculo){
        this.veiculos.add(veiculo);
    }

    public List<Veiculo> buscar(String palavraBuscada) {
        return this.veiculos.stream()
                .filter(veiculo -> {
                    return veiculo.getModelo().toUpperCase().contains(palavraBuscada.toUpperCase()) ||
                            veiculo.getPlaca().toUpperCase().contains(palavraBuscada.toUpperCase());
                })
                .collect(Collectors.toList());
    }

    public List<Veiculo> listarTodos() {
        return this.veiculos;
    }


}
