package com.car.rental.service.services.impl;

import com.car.rental.service.dao.Car;
import com.car.rental.service.repositories.CarRespository;
import com.car.rental.service.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class CarServiceImpl implements CarService {
    private CarRespository carRespository;
    @Override
    public Car create(Car entity) {
        return null;
    }

    @Override
    public Car update(Car entity) {
        return null;
    }

    @Override
    public Car findById(Long id) {
        return null;
    }

    @Override
    public List<Car> findAll() {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
