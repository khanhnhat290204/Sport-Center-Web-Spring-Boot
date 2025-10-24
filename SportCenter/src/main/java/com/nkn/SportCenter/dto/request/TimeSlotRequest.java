package com.nkn.SportCenter.dto.request;

import java.time.LocalTime;

public class TimeSlotRequest {
    private LocalTime start_time;
    private LocalTime end_time;

    
    public LocalTime getStart_time() {
        return start_time;
    }
    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }
    public LocalTime getEnd_time() {
        return end_time;
    }
    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }
}
