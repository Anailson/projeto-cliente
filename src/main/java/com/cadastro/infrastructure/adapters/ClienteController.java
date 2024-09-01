package com.cadastro.infrastructure.adapters;

import com.cadastro.application.services.ClienteServiceImpl;
import com.cadastro.domain.entities.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteServiceImpl clienteService;

    public ClienteController(ClienteServiceImpl clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public Cliente criarCliente(@RequestBody  Cliente cliente) {

        return clienteService.salvarCliente(cliente);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/BuscarRegistroId")
    public Cliente buscarClientePorId(@RequestParam Long id) {
        return clienteService.buscarClientePorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.atualizarCliente(id, cliente);
    }

    //Exclusão física
    @DeleteMapping("/deleteCliente")
    public void deletarCliente(@RequestParam  Long id) {

        clienteService.deletarCliente(id);
    }

    //lógica
    @DeleteMapping("/excluir-logicamente")
    public void excluirLogicamenteCliente(@RequestParam Long id) {
        clienteService.excluirLogicamenteCliente(id);
    }

}
