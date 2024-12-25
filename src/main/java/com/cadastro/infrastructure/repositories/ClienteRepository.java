package com.cadastro.infrastructure.repositories;

import com.cadastro.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Busca todos os clientes ativos
    @Query("SELECT c FROM Cliente c WHERE c.ativo = true")
    List<Cliente> findAll();
}
