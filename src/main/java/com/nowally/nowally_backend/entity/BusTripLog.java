package com.nowally.nowally_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bus_trip_logs")
public class BusTripLog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "trip_id")
    private UUID tripID;

    private String busID = "PY052793";
    @Column(name = "route_id")
    private String routeID;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "ends_at")
    private LocalDateTime endsAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
