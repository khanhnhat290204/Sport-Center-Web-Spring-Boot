package com.nkn.SportCenter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkn.SportCenter.dto.request.BookingRequest;
import com.nkn.SportCenter.entities.Booking;
import com.nkn.SportCenter.entities.Court;
import com.nkn.SportCenter.entities.Time_slot;
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

        Optional<User> user_object=this.userRepo.findById(request.getUser());
        User user=user_object.get();

        Optional<Court> court_object=this.courtRepo.findById(request.getCourt());
        Court court=court_object.get();

        Optional<Time_slot> time_slot_object=this.time_slotRepo.findById(request.getTime_slot());
        Time_slot time_slot=time_slot_object.get();
        
        booking.setUser(user);
        booking.setCourt(court);
        booking.setTime_slot(time_slot);
        return this.bookingRepo.save(booking);
    }
}
