package com.projetospring.desafiobackend.repositories;

import com.projetospring.desafiobackend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
