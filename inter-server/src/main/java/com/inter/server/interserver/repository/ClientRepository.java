package com.inter.server.interserver.repository;

import com.inter.server.interserver.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByCpf(String cpf);

    Optional<Client> findById(Long id);
}
