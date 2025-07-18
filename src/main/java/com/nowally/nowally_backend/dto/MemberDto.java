package com.nowally.nowally_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class MemberDto {
    private UUID memberId;
    private String name;
    private String email;
    private String phone;
    private String password;
    private LocalDateTime createdAt;
}


