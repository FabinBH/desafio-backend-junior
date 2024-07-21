package com.projetospring.desafiobackend.controllers;

import com.projetospring.desafiobackend.entities.Client;
import com.projetospring.desafiobackend.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Client> listarCliente(@PathVariable Long id) {
        return clientService.listarClientePeloID(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Client> cadastrarCliente(@RequestBody Client client) {
        Client newClient = clientService.cadastrarCliente(client);
        return ResponseEntity.ok(newClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> editarCliente(@PathVariable Long id, @RequestBody Client client) {
        Client editClient = clientService.editarCliente(id, client);
        return ResponseEntity.ok(editClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        clientService.excluirCliente(id);
        return ResponseEntity.noContent().build();
    }
}
