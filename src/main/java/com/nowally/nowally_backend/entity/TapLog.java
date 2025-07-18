package com.nowally.nowally_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tap_log")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TapLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID logId;

    private String nfcId;

    private UUID tripId;

    @Column(nullable = false)
    private String entryStop;

    private String exitStop;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
