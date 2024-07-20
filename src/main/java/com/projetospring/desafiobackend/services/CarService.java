package com.projetospring.desafiobackend.services;

import com.projetospring.desafiobackend.entities.Car;
import com.projetospring.desafiobackend.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car cadastrar(Car carro) {
        return carRepository.save(carro);
    }

    public void excluir(Long id) {
        carRepository.deleteById(id);
    }

    public List<Car> listar() {
        return carRepository.findAll();
    }

    public Optional<Car> listarID(Long id) {
        return carRepository.findById(id);
    }
}
