package com.nowally.nowally_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "linked_at", nullable = false, updatable = false)
    private LocalDateTime linkedAt;

    @Column(name = "nfc_id", nullable = false, unique = true)
    private String nfcId;

    @Column(name = "card_id", nullable = false, unique = true)
    private String cardId;

    @PrePersist
    protected void onCreate() {
        linkedAt = LocalDateTime.now();
        if (nfcId == null || nfcId.isEmpty()) {
            nfcId = generateNfcId();
        }
    }

    private String generateNfcId() {
        // Generate format: XXX1234 (3 uppercase letters + 4 digits)
        String letters = randomLetters(3);
        String digits = String.format("%04d", new Random().nextInt(10000));
        return letters + digits;
    }

    private String randomLetters(int count) {
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            char letter = (char) ('A' + random.nextInt(26));
            result.append(letter);
        }
        return result.toString();
    }
}
