package com.car.rental.service.repositories;

import com.car.rental.service.dao.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository extends JpaRepository<Employee, Long> {
}
