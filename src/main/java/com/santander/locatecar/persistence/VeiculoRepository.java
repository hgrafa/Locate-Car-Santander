package com.santander.locatecar.persistence;

import com.santander.locatecar.model.Veiculo;

import java.util.List;

public interface VeiculoRepository extends RepositoryGenerico<Veiculo> {
    List<Veiculo> buscarPeloModelo(String modelo);

}

