package persistence;

import model.Cliente;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClienteRepository {
    private Map<String,Cliente> clientes;

    public ClienteRepository(){
        this.clientes = new HashMap<>();
    }

    public void cadastrar(Cliente cliente){
        this.clientes.put(cliente.getDocumento(),cliente);
    }

    public List<Cliente> buscar(String palavraBuscada) {
        return this.clientes.values().stream()
                .filter(cliente -> {
                    return cliente.getNome().toUpperCase().contains(palavraBuscada.toUpperCase()) ||
                            cliente.getDocumento().toUpperCase().contains(palavraBuscada.toUpperCase());
                })
                .collect(Collectors.toList());
    }

    public Cliente buscarPorDocumentoExato(String numeroDoDodumento){
        return this.clientes.get(numeroDoDodumento);
    }

    public List<Cliente> listarTodos() {
        return this.clientes.values().stream().toList();
    }


}