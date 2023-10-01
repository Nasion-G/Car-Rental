package com.car.rental.service.entities;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @ManyToOne
    @JoinColumn(name = "employee")
    private Employee employee;

    private LocalDate loanDate;

    @OneToOne
    @JoinColumn(name = "loan")
    private Reservation reservation;

    private String comments;
}
