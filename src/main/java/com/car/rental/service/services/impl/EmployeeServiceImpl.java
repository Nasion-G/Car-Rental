package com.car.rental.service.services.impl;

import com.car.rental.service.dao.Car;
import com.car.rental.service.dao.Employee;
import com.car.rental.service.exceptions.GenericExceptions;
import com.car.rental.service.repositories.EmployeeRespository;
import com.car.rental.service.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRespository employeeRespository;

    @Override
    public Employee create(Employee employee) {

        employeeRespository.save(employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        employeeRespository.save(employee);
        return employee;
    }

    @Override
    public Employee findById(Long id) {
        Optional<Employee> employee = employeeRespository.findById(id);
        return employee.orElseThrow(() -> GenericExceptions.notFound(id));
    }

    @Override
    public List<Employee> getAll() {
        return employeeRespository.findAll();
    }

    @Override
    public String delete(Long id) {
        employeeRespository.deleteById(id);
        return String.format("Employee with id %d has been removed", id);

    }

}
