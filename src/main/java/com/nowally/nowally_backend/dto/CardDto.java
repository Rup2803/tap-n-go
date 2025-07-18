package com.nowally.nowally_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class CardDto {
    private UUID cardId;
    private UUID memberId;
    private String card_name;
    private float balance;
    private LocalDateTime createdAt;
}


