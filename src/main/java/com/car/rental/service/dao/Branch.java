package com.car.rental.service.dao;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchId;

    @OneToMany(mappedBy = "employee_branch")
    private List<Employee> employees;

    @OneToMany(mappedBy = "car_branch")
    private List<Car> cars;
}
