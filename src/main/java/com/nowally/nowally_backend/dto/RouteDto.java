package com.nowally.nowally_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class RouteDto {
    private String routeId;
    private List<String> listOfStoppings;
    private LocalDateTime createdAt;
}


