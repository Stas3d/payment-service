package com.example.payments.infrastructure.store.repositories;

import com.example.payments.infrastructure.store.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
