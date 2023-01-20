package controllers;

import model.Agencia;
import model.TipoVeiculo;
import model.Veiculo;
import persistence.AgenciaRepository;
import persistence.VeiculosRepository;

import java.util.List;

public class AgenciaController {

    private AgenciaRepository repositorio;

    public AgenciaController(){
        this.repositorio = new AgenciaRepository();
    }

    public void cadastrar(String nome, String endereco){
        Agencia novaAgencia = new Agencia(nome, endereco);
        this.repositorio.cadastrar(novaAgencia);
    }

    public List<Agencia> buscar(String palavraBuscada) {
        return this.repositorio.buscar(palavraBuscada);
    }
}
