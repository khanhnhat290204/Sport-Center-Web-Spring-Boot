package com.nkn.SportCenter.mapper;

import org.mapstruct.Mapper;

import com.nkn.SportCenter.dto.request.TimeSlotRequest;
import com.nkn.SportCenter.entities.TimeSlot;

@Mapper(componentModel = "spring")
public interface TimeSlotMapper {
    TimeSlot toTimeSlot(TimeSlotRequest request);
}
