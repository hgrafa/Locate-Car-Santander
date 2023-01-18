package com.santander.locatecar.persistence;

import com.santander.locatecar.model.Cliente;

import java.util.List;

public interface ClienteRepository extends RepositoryGenerico<Cliente> {
    List<Cliente> buscarPeloNome(String parteNome);

}

