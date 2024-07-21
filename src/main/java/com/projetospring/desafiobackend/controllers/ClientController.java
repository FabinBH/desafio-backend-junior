package com.projetospring.desafiobackend.controllers;

import com.projetospring.desafiobackend.entities.Client;
import com.projetospring.desafiobackend.services.CarService;
import com.projetospring.desafiobackend.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public List<Client> listarClientes() {
        return clientService.listarClientes();
    }
}
