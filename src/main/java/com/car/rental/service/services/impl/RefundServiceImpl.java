package com.car.rental.service.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.car.rental.service.dao.Refund;
import com.car.rental.service.repositories.RefundRepo;
import com.car.rental.service.exceptions.GenericExceptions;
import com.car.rental.service.services.RefundService;

import lombok.*;

@Service
@RequiredArgsConstructor
@Transactional
public class RefundServiceImpl implements RefundService {
    public final RefundRepo refundRepo;

    @Override
    public Refund create(Refund refund) {
        refundRepo.save(refund);
        return refund;
    }

    @Override
    public Refund update(Refund refund) {
        refundRepo.save(refund);
        return refund;
    }

    @Override
    public Refund findById(Long id) {
        Optional<Refund> refund = refundRepo.findById(id);
        return refund.orElseThrow(() -> GenericExceptions.notFound(id));
    }

    @Override
    public List<Refund> getAll() {
        return refundRepo.findAll();
    }

    @Override
    public String delete(Long id) {
        refundRepo.deleteById(id);
        return String.format("Refund with ID %d deleted", id);
    }

}
