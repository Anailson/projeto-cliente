package com.cadastro.domain.ports;

import com.cadastro.domain.entities.Cliente;

import java.util.List;

public interface ClienteServicePort {

    Cliente salvarCliente(Cliente cliente);

    Cliente atualizarCliente(Long id, Cliente cliente);

    void deletarCliente(Long id);

    Cliente buscarClientePorId(Long id);

    List<Cliente> listarClientes();

    // Novo método para exclusão lógica
    void excluirLogicamenteCliente(Long id);
}

/**
 * Implementação da Porta de Entrada
 */