package com.santander.locatecar.business;

import com.santander.locatecar.exception.RegistroDuplicadoException;
import com.santander.locatecar.model.Agencia;
import com.santander.locatecar.persistence.AgenciaRepository;

public class GerenciadorDeAgencia {
    private final AgenciaRepository agenciaRepository;

    public GerenciadorDeAgencia(AgenciaRepository agenciaRepository) {
        this.agenciaRepository = agenciaRepository;
    }

    public Agencia criarAgencia(String nome, String logradouro) {
        if (existeAgencia(nome)) {
            throw new RegistroDuplicadoException("Agencia", nome);
        }

        Agencia novaAgencia = new Agencia(nome, logradouro);
        agenciaRepository.salvar(novaAgencia);
        return novaAgencia;
    }

    public Agencia buscarAgenciaPorNome(String nome) {
        return agenciaRepository.buscarPeloId(nome);
    }

    public boolean existeAgencia(String nome) {
        return agenciaRepository.buscarPeloId(nome) != null;
    }
}
