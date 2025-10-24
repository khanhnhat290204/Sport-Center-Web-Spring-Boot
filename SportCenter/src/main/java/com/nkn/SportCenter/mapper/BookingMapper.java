package com.nkn.SportCenter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.nkn.SportCenter.dto.request.BookingRequest;
import com.nkn.SportCenter.entities.Booking;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mapping(target = "court", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "time_slot", ignore = true)
    Booking toBooking(BookingRequest request);
}
