package com.nkn.SportCenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nkn.SportCenter.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    
}
