package com.nowally.nowally_backend.service.impl;

import com.nowally.nowally_backend.dto.BusTripLogDto;
import com.nowally.nowally_backend.entity.BusTripLog;
import com.nowally.nowally_backend.mapper.BusTripLogMapper;
import com.nowally.nowally_backend.repository.BusTripLogRepository;
import com.nowally.nowally_backend.service.BusTripLogService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class BusTripLogServiceImpl implements BusTripLogService {

    @Autowired
    private BusTripLogRepository busTripLogRepository;

    @Override
    public BusTripLogDto createBusTripLog(BusTripLogDto busTripLogDto) {
        BusTripLog busTripLog = BusTripLogMapper.mapToBusTripLog(busTripLogDto);
        busTripLog.setBusID("PY052793");
        BusTripLog savedBusTripLog = busTripLogRepository.save(busTripLog);
        return BusTripLogMapper.mapToBusTripLogDto(savedBusTripLog);
    }

    @Override
    public BusTripLogDto endBusTrip(UUID tripId) {
        Optional<BusTripLog> optionalTrip = busTripLogRepository.findById(tripId);
        if (optionalTrip.isPresent()) {
            BusTripLog trip = optionalTrip.get();
            trip.setEndsAt(LocalDateTime.now());
            BusTripLog savedBusTripLog = busTripLogRepository.save(trip);
            return BusTripLogMapper.mapToBusTripLogDto(savedBusTripLog);
        } else {
            throw new EntityNotFoundException("Trip not found with ID: " + tripId);
        }
    }


}
