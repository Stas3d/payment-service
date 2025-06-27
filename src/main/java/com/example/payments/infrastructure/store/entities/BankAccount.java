package com.example.payments.infrastructure.store.entities;

import com.example.payments.domain.dto.BankAccountStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "accounts")
@NoArgsConstructor
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "number", nullable = false, unique = true)
    private UUID accountNumber;

    @ManyToOne
    @JoinColumn(name = "customers_id")
    private Customer customerId;

    @Column(name = "balance")
    private String balance;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BankAccountStatus status;

    @Column(name = "created_at")
    private Date createdAt;

    public BankAccount(UUID accountNumber,
                       String balance,
                       String currency) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
        this.status = BankAccountStatus.INITIATED;
    }
}
