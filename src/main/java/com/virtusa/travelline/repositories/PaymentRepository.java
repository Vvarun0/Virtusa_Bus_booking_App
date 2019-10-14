package com.virtusa.travelline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.travelline.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
