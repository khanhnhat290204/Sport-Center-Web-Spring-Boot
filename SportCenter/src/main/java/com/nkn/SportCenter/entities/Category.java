package com.nkn.SportCenter.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    
    public int getId() {
        return id;
    }
    private String name;

    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
