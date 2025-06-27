package com.example.payments.infrastructure.store.repositories;

import com.example.payments.infrastructure.store.entities.PaymentTransactionRefund;
import org.springframework.data.repository.CrudRepository;

public interface PaymentTransactionRefundRepository extends CrudRepository<PaymentTransactionRefund, Long> {
}
