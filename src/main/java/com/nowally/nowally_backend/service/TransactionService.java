package com.nowally.nowally_backend.service;

import com.nowally.nowally_backend.dto.TapLogDto;
import com.nowally.nowally_backend.dto.TransactionDto;
import com.nowally.nowally_backend.entity.Transaction;

import java.util.UUID;

public interface TransactionService {
    TransactionDto createTransaction(TransactionDto transactionDto);

    TransactionDto createTransactionForPayment(TapLogDto tapLogDto);
}