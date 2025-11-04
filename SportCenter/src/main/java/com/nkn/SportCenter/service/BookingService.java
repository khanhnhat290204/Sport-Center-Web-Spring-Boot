package com.nkn.SportCenter.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkn.SportCenter.dto.request.BookingRequest;
import com.nkn.SportCenter.dto.request.FindBookingRequest;
import com.nkn.SportCenter.entities.Booking;
import com.nkn.SportCenter.entities.BookingStatus;
import com.nkn.SportCenter.entities.Court;
import com.nkn.SportCenter.entities.TimeSlot;
import com.nkn.SportCenter.entities.User;
import com.nkn.SportCenter.mapper.BookingMapper;
import com.nkn.SportCenter.repository.BookingRepository;
import com.nkn.SportCenter.repository.CourtRepository;
import com.nkn.SportCenter.repository.TimeSlotRepository;
import com.nkn.SportCenter.repository.UserRepository;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private CourtRepository courtRepo;
    @Autowired
    private TimeSlotRepository time_slotRepo;
    @Autowired
    private BookingMapper bookingMapper;

    public Booking createBooking(BookingRequest request){
        Booking booking=this.bookingMapper.toBooking(request);

        User user=this.userRepo.findById(request.getUser()).orElseThrow(()-> new RuntimeException("User not found"));

        Court court=this.courtRepo.findById(request.getCourt()).orElseThrow(()-> new RuntimeException("Court not found"));
        List<TimeSlot> slots= new ArrayList<>();
        for(int i : request.getTime_slot()){
            TimeSlot time_slot=this.time_slotRepo.findById(i).orElseThrow(()-> new RuntimeException("Time slot not found"));
            slots.add(time_slot);
            System.err.println(time_slot);
        }

        double total_price= court.getPrice()*slots.size();
        double deposit_amount=total_price*0.1;

        booking.setUser(user);
        booking.setCourt(court);
        booking.setTime_slot(slots);
        booking.setDeposit_amount(deposit_amount);
        booking.setTotal_price(total_price);
        return this.bookingRepo.save(booking);
    }

    public void updateBookingStatus(int id,BookingStatus status){
        Booking booking=this.bookingRepo.findById(id).orElseThrow(()-> new RuntimeException("Booking not found"));
        booking.setBooking_status(status);
        this.bookingRepo.save(booking);
    }

    public Booking findBookingById(int id){
        return this.bookingRepo.findById(id).orElseThrow(()-> new RuntimeException("Booking not found"));
    }

    public List<Booking> findBookingInRange(FindBookingRequest request){
        return this.bookingRepo.findBookingsInRange(request.getCourt_id(),request.getBegin(),request.getEnd());
    }
}
