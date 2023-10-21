package com.car.rental.service.services;

import com.car.rental.service.dao.Rental;

import java.util.List;

public interface RentalService {
    Rental create(Rental rental);

    Rental update(Rental rental);

    Rental findById(Long id);

    List<Rental> findAll();

    String delete(Long id);

}
