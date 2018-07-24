package com.ecomm.chkt.payment.repository.impl;

import com.ecomm.chkt.payment.repository.AddPaymentRepository;
import com.ecomm.chkt.payment.repository.domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

@Repository
public class AddPaymentRepositoryImpl implements AddPaymentRepository {

    static final String GET_PAYMENT_ID_QRY = "select max(o_payment_id) from payment";

    @Autowired
    private CassandraOperations cassandraOperations;

    public Integer addPayment(int orderId, float amt) {
        Integer paymentId = cassandraOperations.selectOne(GET_PAYMENT_ID_QRY, Integer.class);
        cassandraOperations.insert(new Payment(orderId, ++paymentId, amt));
        return paymentId;
    }
}