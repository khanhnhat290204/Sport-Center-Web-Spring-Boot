package com.nkn.SportCenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nkn.SportCenter.dto.request.CourtRequest;
import com.nkn.SportCenter.entities.Court;
import com.nkn.SportCenter.service.CourtService;

@RestController
public class CourtController {
    @Autowired
    private CourtService courtService;

    @GetMapping("/court")
    List<Court> getAllCourt(){
        return this.courtService.getAllCourt();
    }

    @PostMapping("/court")
    Court creaCourt(@RequestBody CourtRequest request){
        return this.courtService.createCourt(request);
    }

}
