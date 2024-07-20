package com.projetospring.desafiobackend.repositories;

import com.projetospring.desafiobackend.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
