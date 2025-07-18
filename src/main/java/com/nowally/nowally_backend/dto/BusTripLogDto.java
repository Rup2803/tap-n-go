package com.nowally.nowally_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusTripLogDto {
    private UUID tripID;
    private String busID;
    private String routeID;
    private LocalDateTime createdAt;
    private LocalDateTime endsAt;
}
