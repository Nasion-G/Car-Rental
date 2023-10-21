package com.car.rental.service.services.impl;

import com.car.rental.service.dao.Car;
import com.car.rental.service.dao.Refund;
import com.car.rental.service.exceptions.GenericExceptions;
import com.car.rental.service.repositories.CarRespository;
import com.car.rental.service.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CarServiceImpl implements CarService {
    private CarRespository carRespository;
    @Override
    public Car create(Car car) {
     carRespository.save(car);
     return car;
    }

    @Override
    public Car update(Car car) {
        carRespository.save(car);
        return car;
    }

    @Override
    public Car findById(Long id) {
        Optional<Car> car = carRespository.findById(id);
        return car.orElseThrow(() -> GenericExceptions.notFound(id));

    }

    @Override
    public List<Car> findAll() {
        return carRespository.findAll();

    }

    @Override
    public String delete(Long id) {
        carRespository.deleteById(id);
        return String.format("Car with id %d has been removed", id);

    }
}
