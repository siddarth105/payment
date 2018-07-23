package com.ecomm.chkt.payment.service;

import com.ecomm.chkt.payment.repository.AddPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddPaymentServiceImpl implements AddPaymentService {

    @Autowired
    private AddPaymentRepository addPaymentRepository;

    public Integer addPayment(int orderId, float amount) {
        Integer paymentId = addPaymentRepository.addPayment(orderId, amount);
        return paymentId;
    }

}
