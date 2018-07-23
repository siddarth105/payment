package com.ecomm.chkt.payment.repository.domain;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("payment")
public class Payment {

    @Column("o_order_id")
    private int orderId;

    @PrimaryKey("o_payment_id")
    private int paymentId;

    @Column("amount")
    private float amount;

    public Payment(int orderId, int paymentId, float amount) {
        this.orderId = orderId;
        this.paymentId = paymentId;
        this.amount = amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public float getAmount() {
        return amount;
    }
}
