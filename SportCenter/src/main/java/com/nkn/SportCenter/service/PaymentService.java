package com.nkn.SportCenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkn.SportCenter.dto.request.PaymentRequest;
import com.nkn.SportCenter.entities.Booking;
import com.nkn.SportCenter.entities.BookingStatus;
import com.nkn.SportCenter.entities.Payment;
import com.nkn.SportCenter.entities.PaymentType;
import com.nkn.SportCenter.mapper.PaymentMapper; 
import com.nkn.SportCenter.repository.BookingRepository;
import com.nkn.SportCenter.repository.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository payRepo;
    @Autowired
    private PaymentMapper payMapper;
    @Autowired
    private BookingRepository bookingRepo;

    public Payment createPayment(int book_id,PaymentRequest request){
        Payment payment=this.payMapper.toPayment(request);
        Booking booking= this.bookingRepo.findById(book_id).orElseThrow(()-> new RuntimeException("Booking not found"));
        request.setBooking(booking);
        System.err.println(request.getPaymentType());
        if(request.getPaymentType()==PaymentType.DEPOSIT){
            booking.setBooking_status(BookingStatus.DEPOSITED);
            payment.setTotal_price(booking.getTotal_price()*0.1);
        }
        if(request.getPaymentType()==PaymentType.PAY){
            List<Payment> pre_pay=this.payRepo.findByBooking(booking);
            if(pre_pay!=null){
                for (Payment pay : pre_pay) {
                    payment.setTotal_price(booking.getTotal_price()-pay.getTotal_price());
                }
            }
            booking.setBooking_status(BookingStatus.COMPLETED);
        }
        payment.setBooking(booking);
        System.err.println(payment.getTotal_price());
        return this.payRepo.save(payment);
    }
}
