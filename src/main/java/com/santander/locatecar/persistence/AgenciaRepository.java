package com.santander.locatecar.persistence;

import com.santander.locatecar.model.Agencia;

import java.util.List;

public interface AgenciaRepository extends RepositoryGenerico<Agencia> {

    List<Agencia> buscarPeloLogradouro(String parteLogradouro);

}

