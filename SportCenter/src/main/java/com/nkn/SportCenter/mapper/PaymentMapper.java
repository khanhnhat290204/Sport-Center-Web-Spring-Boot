package com.nkn.SportCenter.mapper;

import org.mapstruct.Mapper;

import com.nkn.SportCenter.dto.request.PaymentRequest;
import com.nkn.SportCenter.entities.Payment;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    Payment toPayment(PaymentRequest request);
}
