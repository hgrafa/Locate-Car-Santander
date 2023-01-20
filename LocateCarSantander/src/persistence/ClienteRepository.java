package persistence;

import model.Cliente;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteRepository {
    private List<Cliente> clientes;

    public ClienteRepository(){
        this.clientes = new ArrayList<Cliente>();
    }

    public void cadastrar(Cliente cliente){
        this.clientes.add(cliente);
    }

    public List<Cliente> buscar(String palavraBuscada) {
        return this.clientes.stream()
                .filter(cliente -> {
                    return cliente.getNome().toUpperCase().contains(palavraBuscada.toUpperCase()) ||
                            cliente.getDocumento().toUpperCase().contains(palavraBuscada.toUpperCase());
                })
                .collect(Collectors.toList());
    }

    public List<Cliente> listarTodos() {
        return this.clientes;
    }


}