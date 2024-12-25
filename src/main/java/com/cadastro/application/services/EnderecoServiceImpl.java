package com.cadastro.application.services;

import com.cadastro.domain.entities.Cliente;
import com.cadastro.domain.entities.Endereco;
import com.cadastro.domain.ports.EnderecoServicePort;
import com.cadastro.infrastructure.repositories.ClienteRepository;
import com.cadastro.infrastructure.repositories.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoServicePort {

    private final EnderecoRepository enderecoRepository;
    private final ClienteRepository clienteRepository;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository, ClienteRepository clienteRepository) {
        this.enderecoRepository = enderecoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Endereco salvarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco salvarEndereco(Long clienteId, Endereco endereco) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() ->
                new RuntimeException("Cliente não encontrado com o ID: " + clienteId));
        endereco.setCliente(cliente); // Associa o cliente ao endereço
        return enderecoRepository.save(endereco);
    }

    @Override
    public List<Endereco> listarEnderecosPorCliente(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() ->
                new RuntimeException("Cliente não encontrado com o ID: " + clienteId));
        return cliente.getEnderecos();
    }

    @Override
    public Endereco buscarEnderecoPorId(Long enderecoId) {
        return enderecoRepository.findById(enderecoId).orElseThrow(() ->
                new RuntimeException("Endereço não encontrado com o ID: " + enderecoId));
    }
}
