package com.nkn.SportCenter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.nkn.SportCenter.dto.request.BookingRequest;
import com.nkn.SportCenter.entities.Booking;
import com.nkn.SportCenter.entities.Court;
import com.nkn.SportCenter.entities.TimeSlot;
import com.nkn.SportCenter.entities.User;
import com.nkn.SportCenter.mapper.BookingMapper;
import com.nkn.SportCenter.repository.BookingRepository;
import com.nkn.SportCenter.repository.CourtRepository;
import com.nkn.SportCenter.repository.TimeSlotRepository;
import com.nkn.SportCenter.repository.UserRepository;
import com.nkn.SportCenter.service.BookingService;

public class BookingServiceTest {
    @Mock
    private BookingRepository bookingRepo;

    @Mock
    private UserRepository userRepo;

    @Mock
    private CourtRepository courtRepo;

    @Mock
    private TimeSlotRepository time_slotRepo;

    @Mock
    private BookingMapper bookingMapper;

    @InjectMocks
    private BookingService bookingService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateBooking(){

        BookingRequest request= new BookingRequest();
        request.setUser(1);
        request.setCourt(10);
        request.setTime_slot(Arrays.asList(5, 6)); 

        User user = new User();
        ReflectionTestUtils.setField(user, "id", 1);
        when(userRepo.findById(1)).thenReturn(Optional.of(user));

        Court court = new Court();
        ReflectionTestUtils.setField(court, "id", 10);
        court.setPrice(100);
        when(courtRepo.findById(10)).thenReturn(Optional.of(court));

        Booking mappedBooking = new Booking();
        when(bookingMapper.toBooking(request)).thenReturn(mappedBooking);

        TimeSlot slot1 = new TimeSlot();
        TimeSlot slot2 = new TimeSlot();
        ReflectionTestUtils.setField(slot1,"id",5);
        ReflectionTestUtils.setField(slot2,"id",6);

        when(time_slotRepo.findById(5)).thenReturn(Optional.of(slot1));
        when(time_slotRepo.findById(6)).thenReturn(Optional.of(slot2));

        Booking savedBooking = new Booking();
        ReflectionTestUtils.setField(savedBooking, "id", 25);
        when(bookingRepo.save(mappedBooking)).thenReturn(savedBooking);

        Booking result = bookingService.createBooking(request);

        assertEquals(25, result.getId());
        assertEquals(2, mappedBooking.getTime_slot().size());
        assertEquals(200, mappedBooking.getTotal_price());
        assertEquals(20, mappedBooking.getDeposit_amount());

        verify(bookingRepo, times(1)).save(mappedBooking);
    }

}
