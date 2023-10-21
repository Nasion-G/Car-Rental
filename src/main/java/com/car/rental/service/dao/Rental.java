package com.car.rental.service.dao;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String internetDomain;
    private String contactAddress;
    private String owner;
    private String logotype;

    private String branches;
}
