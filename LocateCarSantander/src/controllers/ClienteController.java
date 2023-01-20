package controllers;

import model.TipoCliente;
import model.Cliente;
import persistence.ClienteRepository;


import java.util.List;

public class ClienteController {
    private ClienteRepository repositorio;

    public ClienteController(){
        this.repositorio = new ClienteRepository();
    }

    public void cadastrar(String nome, String documento, TipoCliente tipo){
        Cliente novoCliente = new Cliente(nome, documento, tipo);
        this.repositorio.cadastrar(novoCliente);
    }

    public List<Cliente> buscar(String palavraBuscada) {
        return this.repositorio.buscar(palavraBuscada);
    }

    public Cliente buscarPorDocumentoExato(String palavraBuscada) {
        return this.repositorio.buscarPorDocumentoExato(palavraBuscada);
    }

    public List<Cliente> listarTodos() {
        return this.repositorio.listarTodos();
    }

}
