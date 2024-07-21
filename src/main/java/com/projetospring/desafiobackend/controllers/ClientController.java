package com.projetospring.desafiobackend.controllers;

import com.projetospring.desafiobackend.entities.Client;
import com.projetospring.desafiobackend.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> listarClientes() {
        return clientService.listarClientes();
    }

    @GetMapping("/{id}")
    public Optional<Client> listarCliente(@PathVariable Long id) {
        return clientService.listarClientePeloID(id);
    }

    @PostMapping
    public Client cadastrarCliente(@RequestBody Client client) {
        return clientService.cadastrarCliente(client);
    }

    @PutMapping("/{id}")
    public Client editarCliente(@PathVariable Long id, @RequestBody Client client) {
        return clientService.editarCliente(id, client);
    }

    @DeleteMapping("/{id}")
    public void excluirCliente(@PathVariable Long id) {
        clientService.excluirCliente(id);
    }
}
