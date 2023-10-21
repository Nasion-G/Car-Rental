package com.car.rental.service.services;

import java.util.List;

import com.car.rental.service.dao.Employee;

public interface EmployeeService {
    Employee create(Employee employee);

    Employee update(Employee employee);

    Employee findById(Long id);

    List<Employee> getAll();

    String delete(Long id);
}
