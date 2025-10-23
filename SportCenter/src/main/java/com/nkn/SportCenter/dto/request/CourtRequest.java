package com.nkn.SportCenter.dto.request;

import com.nkn.SportCenter.entities.CourtStatus;

public class CourtRequest {
    private double price;
    private String description;
    private CourtStatus court_status;
    private int category;

    public int getCategory() {
        return category;
    }
    public void setCategory(int category) {
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public CourtStatus getCourt_status() {
        return court_status;
    }
    public void setCourt_status(CourtStatus court_status) {
        this.court_status = court_status;
    }
}
