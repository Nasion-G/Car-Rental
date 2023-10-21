package com.car.rental.service.repositories;

import com.car.rental.service.dao.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRespository extends JpaRepository<Car, Long> {

}
