package com.projetospring.desafiobackend.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Carros")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String marca;

    @Column(nullable = false)
    String modelo;

    @CreationTimestamp
    LocalDateTime dataCadastro;

    public void setMarca(String marca) {
        if (marca != null && !marca.isBlank()) this.marca = marca;
    }

    public void setModelo(String modelo) {
        if (modelo != null && !modelo.isBlank()) this.modelo = modelo;
    }
}
