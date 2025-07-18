package com.nowally.nowally_backend.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TapLogDto {

    private UUID logId;
    private String nfcId;
    private UUID tripId;
    private String entryStop;
    private String exitStop;
    private LocalDateTime createdAt;
}
