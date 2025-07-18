package com.nowally.nowally_backend.mapper;

import com.nowally.nowally_backend.dto.CardDto;
import com.nowally.nowally_backend.entity.Card;

public class CardMapper {
    public static CardDto mapToCardDto (Card card) {
        if (card == null) {
            return null;
        }

        CardDto dto = new CardDto();
        dto.setCardId(card.getCardId());
        dto.setMemberId(card.getMemberId());
        dto.setCard_name(card.getCard_name());
        dto.setBalance(card.getBalance());
        dto.setCreatedAt(card.getCreatedAt());

        return dto;
    }

    public static Card mapToCard (CardDto dto) {
        if (dto == null) {
            return null;
        }

        Card card = new Card();
        card.setCardId(dto.getCardId());
        card.setMemberId(dto.getMemberId());
        card.setCard_name(dto.getCard_name());
        card.setBalance(dto.getBalance());
        card.setCreatedAt(dto.getCreatedAt());

        return card;
    }


}

