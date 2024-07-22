package com.projetospring.desafiobackend.controllers;

import com.projetospring.desafiobackend.entities.Car;
import com.projetospring.desafiobackend.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Car> obterCarro(@PathVariable Long id) {
        return carService.listarCarroPeloID(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Car> cadastro(@RequestBody Car car) {
        return ResponseEntity.ok(carService.cadastrarCarro(car));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> edit(@PathVariable Long id, @RequestBody Car car) {
        return ResponseEntity.ok(carService.editarCarro(id, car));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carService.excluirCarro(id);
        return ResponseEntity.noContent().build();
    }
}
