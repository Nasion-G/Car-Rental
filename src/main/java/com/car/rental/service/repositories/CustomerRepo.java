package com.car.rental.service.repositories;

import com.car.rental.service.dao.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
}
