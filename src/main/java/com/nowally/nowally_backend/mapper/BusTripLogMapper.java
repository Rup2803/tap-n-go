package com.nowally.nowally_backend.mapper;

import com.nowally.nowally_backend.dto.BusTripLogDto;
import com.nowally.nowally_backend.entity.BusTripLog;

public class BusTripLogMapper {

    public static BusTripLogDto mapToBusTripLogDto(BusTripLog log) {
        BusTripLogDto dto = new BusTripLogDto();
        dto.setTripID(log.getTripID());
        dto.setBusID(log.getBusID());
        dto.setRouteID(log.getRouteID());
        dto.setCreatedAt(log.getCreatedAt());
        dto.setEndsAt(log.getEndsAt());
        return dto;
    }

    public static BusTripLog mapToBusTripLog(BusTripLogDto dto) {
        BusTripLog log = new BusTripLog();
        log.setTripID(dto.getTripID());
        log.setBusID(dto.getBusID());
        log.setRouteID(dto.getRouteID());
        log.setCreatedAt(dto.getCreatedAt());
        log.setEndsAt(dto.getEndsAt());
        return log;
    }
}
