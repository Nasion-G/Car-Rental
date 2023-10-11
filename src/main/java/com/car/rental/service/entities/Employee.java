package com.car.rental.service.entities;

import com.car.rental.service.Enum.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(unique = true)
    private String username;
    private String name;
    private String email;

    @OneToOne
    @JoinColumn(name = "branch")
    private Branch branch;

    @Enumerated(EnumType.STRING)
    private Role role;






}
