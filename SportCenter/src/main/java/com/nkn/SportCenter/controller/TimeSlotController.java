package com.nkn.SportCenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nkn.SportCenter.dto.request.TimeSlotRequest;
import com.nkn.SportCenter.entities.Time_slot;
import com.nkn.SportCenter.service.TimeSlotService;

@RestController
public class TimeSlotController {
    @Autowired
    private TimeSlotService time_slotService;

    @PostMapping("/time-slot")
    Time_slot createTime_slot(@RequestBody TimeSlotRequest request){
        return this.time_slotService.createTime_slot(request);
    }
}
