package com.nkn.SportCenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nkn.SportCenter.entities.Court;

@Repository
public interface CourtRepository extends JpaRepository<Court , Integer> {
    
}
