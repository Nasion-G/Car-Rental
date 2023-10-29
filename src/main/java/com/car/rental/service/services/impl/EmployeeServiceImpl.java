package com.car.rental.service.services.impl;

import com.car.rental.service.dao.Employee;
import com.car.rental.service.exceptions.GenericExceptions;
import com.car.rental.service.repositories.EmployeeRepository;
import com.car.rental.service.services.EmployeeService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Employee create(Employee employee) {
        if (employeeRepository.findByUsername(employee.getUsername()).isEmpty()) {
            employee.setPassword(passwordEncoder.encode(employee.getPassword()));
            employee.setActive(true);
            employeeRepository.save(employee);
            return employee;
        } else {
            throw GenericExceptions.usernameExists(employee.getUsername());
        }
    }

    @Override
    public Employee update(Employee employee) {
        if (employee.getEmployeeId() == null) {
            throw GenericExceptions.idIsNull();
        } else {
            Employee existingEmployee = this.findById(employee.getEmployeeId());
            if (existingEmployee.getUsername().equals(employee.getUsername())
                    || employeeRepository.findByUsername(employee.getUsername()).isEmpty()) {
                if (employee.getPassword() != null)
                    employee.setPassword(passwordEncoder.encode(employee.getPassword()));
                if (employee.getName() != null)
                    existingEmployee.setName(employee.getName());
                if (employee.getUsername() != null)
                    existingEmployee.setUsername(employee.getUsername());
                if (employee.getActive() != null)
                    existingEmployee.setActive(employee.getActive());
                if (employee.getRole() != null)
                    existingEmployee.setRole(employee.getRole());
                if (employee.getBranch() != null)
                    existingEmployee.setBranch(employee.getBranch());
                if (employee.getEmail() != null)
                    existingEmployee.setEmail(employee.getEmail());

                employeeRepository.save(existingEmployee);
                return existingEmployee;
            } else if (employeeRepository.findByUsername(employee.getUsername()).isPresent()) {
                throw GenericExceptions.usernameExists(employee.getUsername());
            } else {
                throw GenericExceptions.notFound(employee.getEmployeeId());
            }
        }
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> GenericExceptions.notFound(id));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public String delete(Long id) {
        employeeRepository.deleteById(id);
        return String.format("Employee with id %d has been removed", id);
    }

    @Override
    public Employee getLoggedIn() {
        return employeeRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(() -> GenericExceptions.userNotFoundException("Username",
                        SecurityContextHolder.getContext().getAuthentication().getName()));
    }

    @Override
    public Employee login(Employee employee) {
        Optional<Employee> optional = employeeRepository.findByUsername(employee.getUsername());
        if (optional.get().getPassword() == employee.getPassword()) {
            return employee;
        } else
            return null;
    }
}
