package com.nowally.nowally_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDto {
    private String phoneNumber;
    private String nfcId;
    private String cardId;
}
