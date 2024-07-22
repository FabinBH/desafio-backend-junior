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
            if (!Objects.equals(c.getModelo(), carro.getModelo()) && !Objects.equals(c.getMarca(), carro.getMarca())) return carRepository.save(carro);
        }
        return null;
    }

    public List<Car> listarCarros() {
        return carRepository.findAll();
    }

    public Optional<Car> listarCarroPeloID(Long id) {
        return carRepository.findById(id);
    }

    public Car editarCarro(Long id, Car newCar) {
        Car car = carRepository.findById(id).orElse(null);

        if (car != null) {
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
