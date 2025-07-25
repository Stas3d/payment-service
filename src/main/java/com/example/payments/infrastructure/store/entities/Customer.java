package com.example.payments.infrastructure.store.entities;

import com.example.payments.domain.dto.CustomerStatus;
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
@Table(name = "customers")
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "customer_number", nullable = false, unique = true)
    private UUID customerNumber;

    @OneToMany
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<BankAccount> accounts;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "country")
    private String country;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CustomerStatus status;

    @Column(name = "phone")
    private String customerPhone;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    public Customer(UUID customerNumber,
                    String firstName,
                    String lastName,
                    String country,
                    String customerPhone) {
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.customerPhone = customerPhone;
        this.accounts = new ArrayList<>();
    }
}
