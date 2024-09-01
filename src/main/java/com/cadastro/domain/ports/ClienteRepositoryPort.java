package com.cadastro.domain.ports;

import com.cadastro.domain.entities.Cliente;

import java.util.List;

public interface ClienteRepositoryPort {

    Cliente salvar(Cliente cliente);
    void deletar(Long id);
    Cliente buscarPorId(Long id);
    List<Cliente> listarTodos();
}
