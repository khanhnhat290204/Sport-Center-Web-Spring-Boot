package com.nkn.SportCenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nkn.SportCenter.entities.TimeSlot;


@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot,Integer> {

}
