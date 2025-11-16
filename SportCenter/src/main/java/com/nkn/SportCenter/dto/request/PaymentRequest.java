package com.nkn.SportCenter.dto.request;

import com.nkn.SportCenter.entities.Booking;
import com.nkn.SportCenter.entities.PaymentStatus;
import com.nkn.SportCenter.entities.PaymentType;

public class PaymentRequest {
    private Booking booking;
    private PaymentStatus payment_status;
    private PaymentType paymentType;
    private double total_price;

    public double getTotal_price() {
        return total_price;
    }
    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
    public Booking getBooking() {
        return booking;
    }
    public void setBooking(Booking booking) {
        this.booking = booking;
    }
    public PaymentStatus getPayment_status() {
        return payment_status;
    }
    public void setPayment_status(PaymentStatus payment_status) {
        this.payment_status = payment_status;
    }
    public PaymentType getPaymentType() {
        return paymentType;
    }
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
