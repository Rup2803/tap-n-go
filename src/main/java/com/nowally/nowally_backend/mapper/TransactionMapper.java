package com.nowally.nowally_backend.mapper;

import com.nowally.nowally_backend.dto.TransactionDto;
import com.nowally.nowally_backend.entity.Transaction;

public class TransactionMapper {

    public static TransactionDto mapToTransactionDto(Transaction transaction) {
        return new TransactionDto(
                transaction.getTransactionId(),
                transaction.getCardId(),
                transaction.getTripId(),
                transaction.getType(),
                transaction.getAmount(),
                transaction.getBalanceAfter(),
                transaction.getCreatedAt()
        );
    }

    public static Transaction mapToTransaction(TransactionDto dto) {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(dto.getTransactionId());
        transaction.setCardId(dto.getCardId());
        transaction.setTripId(dto.getTripId());
        transaction.setType(dto.getType());
        transaction.setAmount(dto.getAmount());
        transaction.setBalanceAfter(dto.getBalanceAfter());
        transaction.setCreatedAt(dto.getCreatedAt()); // Will be overwritten on persist, but safe
        return transaction;
    }
}
