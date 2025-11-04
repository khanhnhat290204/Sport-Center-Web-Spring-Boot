package com.nkn.SportCenter.entities;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
    @ManyToMany
    @JoinTable(
    name = "booking_time_slot",
    joinColumns = @JoinColumn(name = "booking_id"),
    inverseJoinColumns = @JoinColumn(name = "time_slot_id")
    )
    private List<TimeSlot> time_slot;
    private LocalDate booking_date;
    private double total_price;
    private double deposit_amount;
    @CreationTimestamp
    private LocalDate created_at;
    @Enumerated(EnumType.STRING)
    private BookingType booking_type;
    @Enumerated(EnumType.STRING)
    private BookingStatus booking_status=BookingStatus.PENDING; 


    public LocalDate getCreated_at() {
        return created_at;
    }
    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }
    public List<TimeSlot> getTime_slot() {
        return time_slot;
    }
    public void setTime_slot(List<TimeSlot> time_slot) {
        this.time_slot = time_slot;
    }
    public int getId() {
        return id;
    }
    public Court getCourt() {
        return court;
    }
    public void setCourt(Court court) {
        this.court = court;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
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
    public BookingType getBooking_type() {
        return booking_type;
    }
    public void setBooking_type(BookingType booking_type) {
        this.booking_type = booking_type;
    }
    public BookingStatus getBooking_status() {
        return booking_status;
    }
    public void setBooking_status(BookingStatus booking_status) {
        this.booking_status = booking_status;
    }

    
}
