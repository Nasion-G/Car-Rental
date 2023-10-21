package com.car.rental.service.security;

import com.car.rental.service.dao.Employee;
import com.car.rental.service.repositories.EmployeeRespository;
import com.car.rental.service.dao.Employee;
import com.car.rental.service.exceptions.GenericExceptions;
import com.car.rental.service.repositories.EmployeeRespository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.swing.text.html.parser.Entity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final EmployeeRespository employeeRespository;

    public UserDetailsServiceImpl(EmployeeRespository employeeRespository) {
        this.employeeRespository = employeeRespository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> user = employeeRepository.findByUsername(username);
        if (user.isPresent()) {
            return new UserDetailsImpl(user.get());
        } else {
            throw GenericExceptions.userNotFoundException("username", username);
        }
    }
}
