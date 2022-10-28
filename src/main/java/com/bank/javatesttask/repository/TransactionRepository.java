package com.bank.javatesttask.repository;

import com.bank.javatesttask.entity.Transaction;
import com.bank.javatesttask.enums.OperationType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Page<Transaction> findAllByType(OperationType type, Pageable pageable);
}
