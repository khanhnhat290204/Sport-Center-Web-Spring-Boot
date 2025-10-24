package com.nkn.SportCenter.mapper;

import org.mapstruct.Mapper;

import com.nkn.SportCenter.dto.request.TimeSlotRequest;
import com.nkn.SportCenter.entities.Time_slot;

@Mapper(componentModel = "spring")
public interface TimeSlotMapper {
    Time_slot toTimeSlot(TimeSlotRequest request);
}
