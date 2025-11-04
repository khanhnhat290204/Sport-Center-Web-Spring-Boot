package com.nkn.SportCenter.dto.request;

import java.time.LocalDate;
import java.util.List;

import com.nkn.SportCenter.entities.BookingStatus;
import com.nkn.SportCenter.entities.BookingType;

public class BookingRequest {
    private int court;
    private int user;
    private List<Integer> time_slot;
    private LocalDate booking_date;
    private double total_price;
    private double deposit_amount;
    private BookingType booking_type;
    private BookingStatus booking_status;

    public List<Integer> getTime_slot() {
        return time_slot;
    }
    public void setTime_slot(List<Integer> time_slot) {
        this.time_slot = time_slot;
    }
    public int getCourt() {
        return court;
    }
    public void setCourt(int court) {
        this.court = court;
    }
    public int getUser() {
        return user;
    }
    public void setUser(int user) {
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
