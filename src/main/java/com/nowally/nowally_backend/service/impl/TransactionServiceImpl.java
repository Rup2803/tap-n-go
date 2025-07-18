package com.nowally.nowally_backend.service.impl;

import com.nowally.nowally_backend.dto.RouteDto;
import com.nowally.nowally_backend.dto.TapLogDto;
import com.nowally.nowally_backend.dto.TransactionDto;
import com.nowally.nowally_backend.entity.*;
import com.nowally.nowally_backend.mapper.TransactionMapper;
import com.nowally.nowally_backend.repository.BusTripLogRepository;
import com.nowally.nowally_backend.repository.CardRepository;
import com.nowally.nowally_backend.repository.PhoneRepository;
import com.nowally.nowally_backend.repository.TransactionRepository;
import com.nowally.nowally_backend.service.RouteService;
import com.nowally.nowally_backend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private BusTripLogRepository busTripLogRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private RouteService routeService;

    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        Card card = cardRepository.findByCardId(UUID.fromString(transactionDto.getCardId()))
                .orElseThrow(() -> new RuntimeException("Card not found with ID: " + transactionDto.getCardId()));

        float currBalance = card.getBalance();
        float newBalance;

        if ("RECHARGE".equalsIgnoreCase(transactionDto.getType())) {
            newBalance = currBalance + transactionDto.getAmount();
        } else if ("PAYMENT".equalsIgnoreCase(transactionDto.getType())) {
            newBalance = currBalance - transactionDto.getAmount();
        } else {
            newBalance = currBalance;
        }

        card.setBalance(newBalance);
        cardRepository.save(card);

        Transaction transaction = TransactionMapper.mapToTransaction(transactionDto);
        transaction.setBalanceAfter(newBalance);
        Transaction savedTransaction = transactionRepository.save(transaction);

        return TransactionMapper.mapToTransactionDto(savedTransaction);
    }

    @Override
    public TransactionDto createTransactionForPayment(TapLogDto tapLogDto) {
        // Step 1: Get the linked card from phone
        List<Phone> phones = phoneRepository.findByNfcId(tapLogDto.getNfcId());
        if (phones.isEmpty()) {
            throw new RuntimeException("Phone with NFC ID not found: " + tapLogDto.getNfcId());
        }

        Phone myPhone = phones.get(0);
        UUID cardId = UUID.fromString(myPhone.getCardId());

        Card card = cardRepository.findByCardId(cardId)
                .orElseThrow(() -> new RuntimeException("Card not found with ID: " + myPhone.getCardId()));

        float currBalance = card.getBalance();

        // Step 2: Get trip route info
        UUID tripId = tapLogDto.getTripId();
        BusTripLog busTripLog = busTripLogRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("Trip not found with ID: " + tripId));

        String routeId = busTripLog.getRouteID();
        RouteDto routeDto = routeService.getStoppingsByRouteId(routeId);
        if (routeDto == null) {
            throw new RuntimeException("Route not found with ID: " + routeId);
        }

        List<String> stoppings = routeDto.getListOfStoppings();
        String entry = tapLogDto.getEntryStop();
        String exit = tapLogDto.getExitStop();

        int entryIndex = stoppings.indexOf(entry);
        int exitIndex = stoppings.indexOf(exit);

        if (entryIndex == -1 || exitIndex == -1) {
            throw new RuntimeException("Invalid stop(s) provided: " + entry + " or " + exit);
        }

        int stopsTraveled = Math.abs(exitIndex - entryIndex);
        final float BASE = 5.0f;
        final float COST_PER_STOP = 2.0f;
        float tripCost = BASE + (stopsTraveled * COST_PER_STOP);

        // Step 3: Deduct balance
        float newBalance = currBalance - tripCost;
        card.setBalance(newBalance);
        cardRepository.save(card);

        // Step 4: Save transaction
        Transaction transaction = new Transaction();
        transaction.setCardId(card.getCardId().toString());
        transaction.setTripId(tripId);
        transaction.setType("PAYMENT");
        transaction.setAmount(tripCost);
        transaction.setBalanceAfter(newBalance);

        Transaction savedTransaction = transactionRepository.save(transaction);

        return TransactionMapper.mapToTransactionDto(savedTransaction);
    }
}
