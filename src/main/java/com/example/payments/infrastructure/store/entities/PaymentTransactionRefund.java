package com.example.payments.infrastructure.store.entities;

import com.example.payments.domain.dto.PaymentTransactionRefundStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "payment_transactions_refund")
@NoArgsConstructor
public class PaymentTransactionRefund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "number", nullable = false, unique = true)
    private UUID number;

    @Column(name = "payment_transaction_number", nullable = false, unique = true)
    private UUID paymentTransaction;

    @Column(name = "refunded_ammount", nullable = false)
    private String refundedAmmount;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "status", nullable = false)
    private PaymentTransactionRefundStatus status;

    @Column(name = "reason")
    private String reason;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "executed_at")
    private Date executedAt;
}
