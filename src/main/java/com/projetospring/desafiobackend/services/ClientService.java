package com.projetospring.desafiobackend.services;

import com.projetospring.desafiobackend.entities.Car;
import com.projetospring.desafiobackend.entities.Client;
import com.projetospring.desafiobackend.repositories.CarRepository;
import com.projetospring.desafiobackend.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    private final CarRepository carRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, CarRepository carRepository) {
        this.clientRepository = clientRepository;
        this.carRepository = carRepository;
    }

    public Client cadastrarCliente(Client client) {
        Car clientCar = client.getCar();

        if (carRepository.existsById(clientCar.getId())) {
            return clientRepository.save(client);
        }
        throw new IllegalArgumentException("Este carro não existe");
    }

    public List<Client> listarClientes() {
        return clientRepository.findAll();
    }

    public Optional<Client> listarClientesPeloID(Long id) {
        return clientRepository.findById(id);
    }

    public Client editarCliente(Long id, Client newClient) {
        Client client = clientRepository.findById(id).orElse(null);

        if (client != null) {
            client.setCpf(newClient.getCpf());
            client.setNome(newClient.getNome());
            client.setDataNascimento(newClient.getDataNascimento());
            if (!carRepository.existsById(newClient.getId())) {
                throw new IllegalArgumentException("Carro inexistente");
            }
            client.setCar(newClient.getCar());
        }

        return client;
    }

    public void excluirCliente(Long id) {
        clientRepository.deleteById(id);
    }
}
