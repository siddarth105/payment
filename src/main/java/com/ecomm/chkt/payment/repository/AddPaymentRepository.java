package com.ecomm.chkt.payment.repository;

public interface AddPaymentRepository {

    Integer addPayment(int orderId, float amt);
}
