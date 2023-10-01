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
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;
    private LocalDate dateOfBooking;

    @ManyToOne
    @JoinColumn(name = "car")
    private Car car;

    private LocalDate dateFrom;
    private LocalDate dateTo;

    @ManyToOne
    @JoinColumn(name = "branch")
    private Branch branchOfLoan;

    @OneToOne(mappedBy = "loan")
    private Loan loan;

    @OneToOne(mappedBy = "refund")
    private Refund refund;

    private Integer amount;
}
