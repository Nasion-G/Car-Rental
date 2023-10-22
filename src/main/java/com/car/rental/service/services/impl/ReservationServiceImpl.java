package com.car.rental.service.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.car.rental.service.dao.Reservation;
import com.car.rental.service.repositories.ReservationRepo;
import com.car.rental.service.exceptions.GenericExceptions;
import com.car.rental.service.services.ReservationService;

import lombok.*;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationServiceImpl implements ReservationService {
    public final ReservationRepo reservationRepo;

    @Override
    public Reservation create(Reservation reservation) {
        reservationRepo.save(reservation);
        return reservation;
    }

    @Override
    public Reservation update(Reservation reservation) {
        if (reservation.getReservationId() == null) {
            throw GenericExceptions.idIsNull();
        } else {
            Reservation existingReservation = this.findById(reservation.getReservationId());
            if (reservation.getDateOfBooking() != null)
                existingReservation.setDateOfBooking(reservation.getDateOfBooking());
            if (reservation.getCar() != null)
                existingReservation.setCar(reservation.getCar());
            if (reservation.getDateFrom() != null)
                existingReservation.setDateFrom(reservation.getDateFrom());
            if (reservation.getDateTo() != null)
                existingReservation.setDateTo(reservation.getDateTo());
            if (reservation.getBranch() != null)
                existingReservation.setBranch(reservation.getBranch());
            if (reservation.getRefund() != null)
                existingReservation.setRefund(reservation.getRefund());
            if (reservation.getAmount() != null)
                existingReservation.setAmount(reservation.getAmount());

            reservationRepo.save(existingReservation);
            return existingReservation;
        }
    }

    @Override
    public Reservation findById(Long id) {
        Optional<Reservation> reservation = reservationRepo.findById(id);
        return reservation.orElseThrow(() -> GenericExceptions.notFound(id));
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepo.findAll();
    }

    @Override
    public String delete(Long id) {
        reservationRepo.deleteById(id);
        return String.format("Reservation with ID %d deleted", id);
    }

}
