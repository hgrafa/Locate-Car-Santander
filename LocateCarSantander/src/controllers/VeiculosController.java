package controllers;

import model.Agencia;
import model.Cliente;
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

    public void cadastrar(String placa, String modelo, TipoVeiculo tipo, Boolean disponivel, Agencia agenciaRetirada, Agencia agenciaDevolucao){
        Veiculo novoVeiculo = new Veiculo(placa, modelo, tipo, disponivel, agenciaRetirada, agenciaDevolucao);
        this.repositorio.cadastrar(novoVeiculo);
    }

    public List<Veiculo> buscar(String palavraBuscada) {
        return this.repositorio.buscar(palavraBuscada);
    }

    public Veiculo buscarPorNumeroDaPlaca(String palavraBuscada) {
        return this.repositorio.buscarPorNumeroDaPlaca(palavraBuscada);
    }

    public List<Veiculo> listarTodos() {
        return this.repositorio.listarTodos();
    }

}
