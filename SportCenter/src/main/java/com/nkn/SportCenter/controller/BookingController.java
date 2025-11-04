package com.nkn.SportCenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nkn.SportCenter.dto.request.BookingRequest;
import com.nkn.SportCenter.dto.request.FindBookingRequest;
import com.nkn.SportCenter.entities.Booking;
import com.nkn.SportCenter.service.BookingService;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    Booking createBooking(@RequestBody BookingRequest request){
        return this.bookingService.createBooking(request);
    }

    @GetMapping("/booking")
    List<Booking> findBookingInRange(@RequestBody FindBookingRequest request){
        return this.bookingService.findBookingInRange(request);
    }
}
