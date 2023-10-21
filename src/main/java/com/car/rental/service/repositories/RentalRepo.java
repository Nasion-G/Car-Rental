package com.car.rental.service.repositories;

import com.car.rental.service.dao.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepo extends JpaRepository<Rental, Long> {
}
