package com.nkn.SportCenter.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nkn.SportCenter.entities.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
