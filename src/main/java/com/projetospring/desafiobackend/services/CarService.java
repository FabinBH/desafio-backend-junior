package com.projetospring.desafiobackend.services;

import com.projetospring.desafiobackend.entities.Car;
import com.projetospring.desafiobackend.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car cadastrarCarro(Car carro) {
        List<Car> cars = carRepository.findAll();
        if (cars.isEmpty()) return carRepository.save(carro);

        for (Car c : cars) {
            if (Objects.equals(c.getModelo(), carro.getModelo()) && Objects.equals(c.getMarca(), carro.getMarca())) return null;
        }
        return carRepository.save(carro);
    }

    public List<Car> listarCarros() {
        return carRepository.findAll();
    }

    public Optional<Car> listarCarroPeloID(Long id) {
        return carRepository.findById(id);
    }

    public Car editarCarro(Long id, Car newCar) {
        Car car = carRepository.findById(id).orElse(null);
        var cars = carRepository.findAll();

        if (car != null) {
            for (Car c : cars) {
                if (Objects.equals(c.getModelo(), newCar.getModelo()) && Objects.equals(c.getMarca(), newCar.getMarca())) return null;
            }
            car.setMarca(newCar.getMarca());
            car.setModelo(newCar.getModelo());
            return carRepository.save(car);
        }
        return null;
    }

    public void excluirCarro(Long id) {
        carRepository.deleteById(id);
    }
}
