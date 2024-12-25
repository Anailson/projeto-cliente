package com.cadastro.infrastructure.adapters;

import com.cadastro.application.services.EnderecoServiceImpl;
import com.cadastro.domain.entities.Endereco;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoServiceImpl enderecoService;


    public EnderecoController(EnderecoServiceImpl enderecoService) {
        this.enderecoService = enderecoService;
    }


    // Criar um novo endereço vinculado a um cliente existente
    @PostMapping("/{clienteId}")
    public Endereco criarEndereco(@PathVariable Long clienteId, @RequestBody Endereco endereco) {
        return enderecoService.salvarEndereco(clienteId, endereco);
    }

    // Listar endereços vinculados a um cliente específico
    @GetMapping("/{clienteId}")
    public List<Endereco> listarEnderecosPorCliente(@PathVariable Long clienteId) {
        return enderecoService.listarEnderecosPorCliente(clienteId);
    }
}
