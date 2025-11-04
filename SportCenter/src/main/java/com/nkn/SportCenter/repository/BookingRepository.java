package com.nkn.SportCenter.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nkn.SportCenter.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query("SELECT b FROM Booking b WHERE b.court.id=:court_id AND b.booking_date BETWEEN :begin and :end")
    List<Booking> findBookingsInRange(int court_id,LocalDate begin, LocalDate end);
}
 