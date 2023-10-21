package com.sda.springsecuritydemo.security;

import com.car.rental.service.dao.Employee;
import com.car.rental.service.repositories.EmployeeRespository;
import com.sda.springsecuritydemo.dao.UserEntity;
import com.sda.springsecuritydemo.exceptions.GenericExceptions;
import com.sda.springsecuritydemo.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final EmployeeRespository employeeRespository;

    public UserDetailsServiceImpl(EmployeeRespository employeeRespository) {
        this.employeeRespository = employeeRespository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employee = employeeRespository.findByUsername(username);
        if (employee.isPresent()){
            return new UserDetailsImpl(employee.get());
        } else {
         throw GenericExceptions.userNotFoundException("username", username);
        }
    }
}
