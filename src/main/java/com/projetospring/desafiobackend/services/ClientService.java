package com.projetospring.desafiobackend.services;

import com.projetospring.desafiobackend.entities.Client;
import com.projetospring.desafiobackend.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client cadastrar(Client client) {
        return clientRepository.save(client);
    }

    public void excluir(Long id) {
        clientRepository.deleteById(id);
    }

    public List<Client> listar() {
        return clientRepository.findAll();
    }

    public Optional<Client> listarID(Long id) {
        return clientRepository.findById(id);
    }
}
