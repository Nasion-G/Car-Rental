package com.car.rental.service.services.impl;

import com.car.rental.service.dao.Customer;
import com.car.rental.service.exceptions.GenericExceptions;
import com.car.rental.service.repositories.CustomerRepo;
import com.car.rental.service.services.CustomerService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {
    public final CustomerRepo customerRepo;

    @Override
    public Customer create(Customer customer) {
        customerRepo.save(customer);
        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        customerRepo.save(customer);
        return customer;
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> refund = customerRepo.findById(id);
        return refund.orElseThrow(() -> GenericExceptions.notFound(id));
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public String delete(Long id) {
        customerRepo.deleteById(id);
        return String.format("Customer with ID %d deleted", id);
    }
}
