package controllers;

import model.Agencia;
import model.Endereco;
import model.TipoVeiculo;
import model.Veiculo;
import persistence.AgenciaRepository;
import persistence.VeiculosRepository;

import java.util.List;
import java.util.UUID;

public class AgenciaController {

    private AgenciaRepository repositorio;

    public AgenciaController(){
        this.repositorio = new AgenciaRepository();
    }

    public void cadastrar(String nome, Endereco endereco){
        Agencia novaAgencia = new Agencia(nome, endereco);
        this.repositorio.cadastrar(novaAgencia);
    }

    public void alterarAgencia(UUID id, String nome, Endereco endereco){
        Agencia novaAgencia = new Agencia(id, nome, endereco);
        this.repositorio.cadastrar(novaAgencia);
    }

    public List<Agencia> buscar(String palavraBuscada) {
        return this.repositorio.buscar(palavraBuscada);
    }

    public Agencia buscaPorEndereco(Endereco palavraBuscada) {
        return this.repositorio.buscaPorEndereco(palavraBuscada);
    }

    public Agencia buscarPorId(UUID palavraBuscada) {
        return this.repositorio.buscarPorId(palavraBuscada);
    }
    public List<Agencia> listarTodos() {
        return this.repositorio.listarTodos();
    }

}
