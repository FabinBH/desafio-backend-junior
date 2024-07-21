package com.projetospring.desafiobackend.controllers;

import com.projetospring.desafiobackend.entities.Car;
import com.projetospring.desafiobackend.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public List<Car> obterCarros() {
        return carService.listarCarros();
    }

    @GetMapping("/{id}")
    public Optional<Car> obterCarro(@PathVariable Long id) {
        return carService.listarCarroPeloID(id);
    }

    @PostMapping
    public Car cadastro(@RequestBody Car car) {
        return carService.cadastrarCarro(car);
    }

    @PutMapping("/{id}")
    public Car edit(@PathVariable Long id, @RequestBody Car car) {
        return carService.editarCarro(id, car);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        carService.excluirCarro(id);
    }
}
