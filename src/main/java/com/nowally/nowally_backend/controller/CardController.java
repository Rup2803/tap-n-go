package com.nowally.nowally_backend.controller;

import com.nowally.nowally_backend.dto.CardDto;
import com.nowally.nowally_backend.dto.TransactionDto;
import com.nowally.nowally_backend.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cards")
@CrossOrigin(origins = "http://localhost:5173")

public class CardController {
    private final CardService cardService;


    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public ResponseEntity<CardDto> createCard(@RequestBody CardDto cardDto) {
        CardDto savedCard = cardService.createCard(cardDto);
        return new ResponseEntity<>(savedCard, HttpStatus.CREATED);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<List<CardDto>> getCardsByMemberId(@PathVariable UUID memberId) {
        List<CardDto> cards = cardService.getCardsByMemberId(memberId);
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }
}
