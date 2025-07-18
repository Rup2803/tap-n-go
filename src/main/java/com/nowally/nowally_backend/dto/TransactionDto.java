package com.nowally.nowally_backend.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private UUID transactionId;
    private String cardId;
    private UUID tripId;
    private String type;
    private float amount;
    private float balanceAfter;
    private LocalDateTime createdAt;
}
