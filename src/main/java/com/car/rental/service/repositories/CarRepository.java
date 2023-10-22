package com.car.rental.service.repositories;

import com.car.rental.service.dao.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
