package com.example.payments.store.repositories;

import com.example.payments.configuration.AppTestConfiguration;
import com.example.payments.infrastructure.store.entities.PaymentTransactionRefund;
import com.example.payments.infrastructure.store.repositories.PaymentTransactionRefundRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest(properties = {
        "spring.liquibase.enabled=false"
})
@Import(AppTestConfiguration.class)
class PaymentTransactionRefundRepositoryTest {

    @Autowired
    private PaymentTransactionRefundRepository repository;

    @Test
    void whenCallSave_thenCorrectNumberOfOrdersPersisted() {
        repository.save(new PaymentTransactionRefund(UUID.randomUUID(), "100", "$"));
        repository.save(new PaymentTransactionRefund(UUID.randomUUID(), "100", "$"));

        final var size = repository.count();
        assertEquals(size, 2);
    }
}
