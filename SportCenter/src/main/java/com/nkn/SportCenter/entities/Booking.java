package com.nkn.SportCenter.entities;

import java.time.LocalDate;
import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Court court;
    @ManyToOne
    private User user;
    @ManyToOne
    private Time_slot time_slot;
    private LocalDate booking_date;
    private double total_price;
    private double deposit_amount;
    @Enumerated(EnumType.STRING)
    private BookingType booking_type;
    @Enumerated(EnumType.STRING)
    private BookingStatus booking_status;

    public LocalDate getBooking_date() {
        return booking_date;
    }
    public void setBooking_date(LocalDate booking_date) {
        this.booking_date = booking_date;
    }
    public double getTotal_price() {
        return total_price;
    }
    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
    public double getDeposit_amount() {
        return deposit_amount;
    }
    public void setDeposit_amount(double deposit_amount) {
        this.deposit_amount = deposit_amount;
    }
}
