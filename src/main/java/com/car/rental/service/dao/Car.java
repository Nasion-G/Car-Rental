package com.car.rental.service.dao;

import com.car.rental.service.Enum.Fuel;
import com.car.rental.service.Enum.Transmission;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;
    @Column(unique = true)
    private String model;
    private String brand;
    private Integer year;
    private String color;
    private Double mileage;
    private String description;

    @Enumerated(EnumType.STRING)
    private Fuel fuel;
    private Transmission transmission;

}
