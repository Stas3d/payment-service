package com.example.payments.infrastructure.store.entities;

import com.example.payments.domain.dto.PaymentTransactionStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "payment_transactions")
@NoArgsConstructor
public class PaymentTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tx_number", nullable = false, unique = true)
    private UUID number;

    @Column(name = "amount", nullable = false)
    private String amount;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PaymentTransactionStatus status;

    @Column(name = "error_message")
    private String errorMessage;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "executed_at")
    private Date executedAt;

    public PaymentTransaction(UUID number,
                              String amount,
                              String currency) {
        this.number = number;
        this.amount = amount;
        this.currency = currency;
        this.status = PaymentTransactionStatus.INITIATED;
    }
}
