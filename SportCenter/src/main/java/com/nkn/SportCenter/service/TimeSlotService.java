package com.nkn.SportCenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkn.SportCenter.dto.request.TimeSlotRequest;
import com.nkn.SportCenter.entities.TimeSlot;
import com.nkn.SportCenter.mapper.TimeSlotMapper;
import com.nkn.SportCenter.repository.TimeSlotRepository;

@Service
public class TimeSlotService {
    @Autowired
    private TimeSlotRepository time_slotRepo;
    @Autowired
    private TimeSlotMapper timeSlotMapper;

    public TimeSlot createTime_slot(TimeSlotRequest request){
        TimeSlot time_slot=this.timeSlotMapper.toTimeSlot(request);
        return this.time_slotRepo.save(time_slot);
    }
}
