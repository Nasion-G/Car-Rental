package com.car.rental.service.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.car.rental.service.dao.Branch;
import com.car.rental.service.exceptions.GenericExceptions;
import com.car.rental.service.repositories.BranchRepo;
import com.car.rental.service.services.BranchService;

import lombok.*;

@Service
@RequiredArgsConstructor
@Transactional
public class BranchServiceImpl implements BranchService {
    public final BranchRepo branchRepo;

    @Override
    public Branch create(Branch branch) {
        branchRepo.save(branch);
        return branch;
    }

    @Override
    public Branch update(Branch branch) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Branch findById(Long id) {
        Optional<Branch> branch = branchRepo.findById(id);
        return branch.orElseThrow(() -> GenericExceptions.notFound(id));
    }

    @Override
    public List<Branch> findAll() {
        return branchRepo.findAll();
    }

    @Override
    public String delete(Long id) {
        branchRepo.deleteById(id);
        return String.format("Branch with ID %d deleted", id);
    }
}
