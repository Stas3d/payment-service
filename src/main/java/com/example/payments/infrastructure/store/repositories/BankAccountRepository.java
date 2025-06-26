package com.example.payments.infrastructure.store.repositories;

import com.example.payments.infrastructure.store.entities.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
}
