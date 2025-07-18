package com.nowally.nowally_backend.service;

import com.nowally.nowally_backend.dto.BusTripLogDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface BusTripLogService {
    BusTripLogDto createBusTripLog(BusTripLogDto busTripLogDto);

    BusTripLogDto endBusTrip(UUID tripId);
}
