package com.nowally.nowally_backend.service;

import com.nowally.nowally_backend.dto.CardDto;

import java.util.List;
import java.util.UUID;

public interface CardService {
    CardDto createCard(CardDto cardDto);
    List<CardDto> getCardsByMemberId(UUID memberId);
}
