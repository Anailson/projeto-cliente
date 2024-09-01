package com.cadastro.domain.entities.exceptons;

public class ClienteNaoEncontradoException extends RuntimeException{

    public ClienteNaoEncontradoException(Long id) {
        super("Cliente com ID " + id + " não encontrado");
    }
}
