package com.car.rental.service.services;

import java.util.List;

import com.car.rental.service.dao.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface EmployeeService {
    Employee create(Employee employee);

    Employee update(Employee employee);

    Employee findById(Long id);

    String delete(Long id);

    List<Employee> findAll();
}
