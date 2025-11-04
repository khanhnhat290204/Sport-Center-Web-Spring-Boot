package com.nkn.SportCenter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nkn.SportCenter.entities.Booking;
import com.nkn.SportCenter.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    List<Payment> findByBooking(Booking booking);
}
