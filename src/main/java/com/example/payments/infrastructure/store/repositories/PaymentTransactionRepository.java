package com.example.payments.infrastructure.store.repositories;

import com.example.payments.infrastructure.store.entities.PaymentTransaction;
import org.springframework.data.repository.CrudRepository;

public interface PaymentTransactionRepository extends CrudRepository<PaymentTransaction, Long> {
}
