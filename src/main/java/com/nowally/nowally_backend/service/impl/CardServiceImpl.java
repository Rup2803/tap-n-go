package com.nowally.nowally_backend.service.impl;

import com.nowally.nowally_backend.dto.CardDto;
import com.nowally.nowally_backend.entity.Card;
import com.nowally.nowally_backend.mapper.CardMapper;
import com.nowally.nowally_backend.repository.CardRepository;
import com.nowally.nowally_backend.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public CardDto createCard(CardDto cardDto) {
        Card card = CardMapper.mapToCard(cardDto);
        Card savedCard = cardRepository.save(card);
        return CardMapper.mapToCardDto(savedCard);
    }

    @Override
    public List<CardDto> getCardsByMemberId(UUID memberId) {
        System.out.println("Fetching cards for memberId: " + memberId);

        List<Card> cards = cardRepository.findByMemberId(memberId);
        System.out.println("Fetched cards from DB: " + cards.size());

        for (Card card : cards) {
            System.out.println("Card: " + card); // Optional: Print card details
        }

        List<CardDto> cardDtos = cards.stream()
                .map(card -> {
                    try {
                        return CardMapper.mapToCardDto(card);
                    } catch (Exception e) {
                        System.out.println("Error mapping card: " + card);
                        e.printStackTrace();
                        throw e;
                    }
                })
                .collect(Collectors.toList());

        System.out.println("Successfully mapped all cards.");
        return cardDtos;
    }

}
