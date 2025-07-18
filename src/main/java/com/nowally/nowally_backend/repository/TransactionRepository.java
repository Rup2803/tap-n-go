package com.nowally.nowally_backend.repository;

import com.nowally.nowally_backend.entity.Member;
import com.nowally.nowally_backend.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}