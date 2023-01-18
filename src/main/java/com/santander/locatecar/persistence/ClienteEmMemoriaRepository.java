package com.santander.locatecar.persistence;

import com.santander.locatecar.model.Cliente;

import java.util.ArrayList;
import java.util.List;


public class ClienteEmMemoriaRepository extends RepositoryGenericoEmMemoria<Cliente> implements ClienteRepository {

    @Override
    public List<Cliente> buscarPeloNome(String parteNome) {
        List<Cliente> clientesComParteDesseNome = new ArrayList<>();
        for (Cliente cliente: entidades.values()) {
            if (cliente.getNome().contains(parteNome)) {
                clientesComParteDesseNome.add(cliente);
            }
        }
        return clientesComParteDesseNome;
    }
}
