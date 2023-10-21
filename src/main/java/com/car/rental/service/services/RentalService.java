package com.car.rental.service.services;

import com.car.rental.service.dao.Customer;
import com.car.rental.service.dao.Rental;

import java.util.List;

public interface RentalService {
    Rental create(Rental rental);
    Rental update(Rental rental);
    Rental findById(Long id);
    List<Rental> GetAll();
    String delete(Long id);

}
