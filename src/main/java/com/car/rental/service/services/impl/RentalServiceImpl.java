package com.car.rental.service.services.impl;

import com.car.rental.service.dao.Rental;
import com.car.rental.service.exceptions.GenericExceptions;
import com.car.rental.service.repositories.RentalRepo;
import com.car.rental.service.services.RentalService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RentalServiceImpl implements RentalService {
    public final RentalRepo rentalRepo;

    @Override
    public Rental create(Rental rental) {
        return null;
    }

    @Override
    public Rental update(Rental rental) {
        return null;
    }

    @Override
    public Rental findById(Long id) {
        return rentalRepo.findById(id).orElseThrow(() -> GenericExceptions.notFound(id));
    }

    @Override
    public List<Rental> findAll() {
        return rentalRepo.findAll();
    }

    @Override
    public String delete(Long id) {
        rentalRepo.deleteById(id);
        return String.format("Rental with ID %d deleted", id);
    }
}
