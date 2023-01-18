package com.santander.locatecar.exception;

public class RegistroDuplicadoException extends RuntimeException {

    public RegistroDuplicadoException(String tipoDoRegistro, String valorDoId) {
        super("Já existe um(a) %s com o id %s".formatted(tipoDoRegistro, valorDoId));
    }
}
