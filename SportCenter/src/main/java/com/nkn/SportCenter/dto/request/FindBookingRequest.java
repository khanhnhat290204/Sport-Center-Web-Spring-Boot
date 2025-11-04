package com.nkn.SportCenter.dto.request;

import java.time.LocalDate;

public class FindBookingRequest {
    private LocalDate begin;
    private LocalDate end;
    private int court_id;

    
    public LocalDate getBegin() {
        return begin;
    }
    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }
    public LocalDate getEnd() {
        return end;
    }
    public void setEnd(LocalDate end) {
        this.end = end;
    }
    public int getCourt_id() {
        return court_id;
    }
    public void setCourt_id(int court_id) {
        this.court_id = court_id;
    }
}
