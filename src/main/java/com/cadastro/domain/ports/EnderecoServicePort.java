package com.cadastro.domain.ports;


import com.cadastro.domain.entities.Endereco;

import java.util.List;

public interface EnderecoServicePort {

    Endereco salvarEndereco (Endereco endereco);   // Salvar um endereço associado a um cliente
    Endereco salvarEndereco(Long clienteId, Endereco endereco);

    // Buscar todos os endereços associados a um cliente
    List<Endereco> listarEnderecosPorCliente(Long clienteId);

    // Opcional: Buscar um endereço pelo ID
    Endereco buscarEnderecoPorId(Long enderecoId);

}
