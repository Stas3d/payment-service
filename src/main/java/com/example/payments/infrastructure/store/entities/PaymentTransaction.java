package com.example.payments.infrastructure.store.entities;

import com.example.payments.domain.dto.PaymentTransactionStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    @Column(name = "transaction_number", nullable = false, unique = true)
    private UUID transactionNumber;

    @OneToMany
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<PaymentTransactionRefund> refunds;

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
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "executed_at")
    private Date executedAt;

    public PaymentTransaction(UUID transactionNumber,
                              String amount,
                              String currency) {
        this.transactionNumber = transactionNumber;
        this.amount = amount;
        this.currency = currency;
        this.refunds = new ArrayList<>();
        this.status = PaymentTransactionStatus.INITIATED;
    }
}
