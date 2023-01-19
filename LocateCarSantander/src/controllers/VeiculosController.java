package controllers;

import model.TipoVeiculo;
import model.Veiculo;
import persistence.VeiculosRepository;

import java.util.List;

/*
Classe chamada pelo MenuVeículo, contém a implementação dos métodos (cadastrar, buscar e listar veículo).
Falta implementar o "alterar veículo".
 */
public class VeiculosController {
    private VeiculosRepository repositorio;

    public VeiculosController(){
        this.repositorio = new VeiculosRepository();
    }

    public void cadastrar(String placa, String modelo, TipoVeiculo tipo){
        Veiculo novoVeiculo = new Veiculo(placa, modelo, tipo, true);
        this.repositorio.cadastrar(novoVeiculo);
    }

    public List<Veiculo> buscar(String palavraBuscada) {
        return this.repositorio.buscar(palavraBuscada);
    }

    public List<Veiculo> listarTodos() {
        return this.repositorio.listarTodos();
    }

}
