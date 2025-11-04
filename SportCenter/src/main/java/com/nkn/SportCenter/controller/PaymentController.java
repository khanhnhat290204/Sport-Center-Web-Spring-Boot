package com.nkn.SportCenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nkn.SportCenter.dto.request.PaymentRequest;
import com.nkn.SportCenter.entities.Payment;
import com.nkn.SportCenter.service.PaymentService;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService payService;

    @PostMapping("booking/{id}/payment")
    Payment createPayment(@PathVariable int id, @RequestBody PaymentRequest request){
        return this.payService.createPayment(id,request);
    }
}
