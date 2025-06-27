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

    @Column(name = "tx_refund_number", nullable = false, unique = true)
    private UUID number;

    @Column(name = "payment_transaction_number", nullable = false, unique = true)
    private UUID paymentTransaction;

    @Column(name = "refunded_amount", nullable = false)
    private String refundedAmount;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PaymentTransactionRefundStatus status;

    @Column(name = "reason")
    private String reason;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "executed_at")
    private Date executedAt;

    public PaymentTransactionRefund(UUID number,
                                    UUID paymentTransaction,
                                    String refundedAmount,
                                    String currency) {
        this.number = number;
        this.paymentTransaction = paymentTransaction;
        this.refundedAmount = refundedAmount;
        this.currency = currency;
        this.status = PaymentTransactionRefundStatus.INITIATED;
    }
}
