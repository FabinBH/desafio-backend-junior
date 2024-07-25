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

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CarRepository carRepository;

    public Client cadastrarCliente(Client client) {
        Optional<Car> clientCar = carRepository.findById(client.getCar().getId());

        clientCar.ifPresent(client::setCar);
        return clientRepository.save(client);
    }

    public List<Client> listarClientes() {
        return clientRepository.findAll();
    }

    public Optional<Client> listarClientePeloID(Long id) {
        return clientRepository.findById(id);
    }

    public Client editarCliente(Long id, Client newClient) {
        Client client = clientRepository.findById(id).orElse(null);

        if (client != null) {
            client.setCpf(newClient.getCpf());
            client.setNome(newClient.getNome());
            client.setDataNascimento(newClient.getDataNascimento());
            if (!carRepository.existsById(newClient.getCar().getId())) {
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
