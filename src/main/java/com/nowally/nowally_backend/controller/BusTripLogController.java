package com.nowally.nowally_backend.controller;

import com.nowally.nowally_backend.dto.BusTripLogDto;
import com.nowally.nowally_backend.dto.TapLogDto;
import com.nowally.nowally_backend.service.BusTripLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.SocketOption;
import java.util.UUID;

@RestController
@RequestMapping("/api/bus-trip-logs")
@CrossOrigin(origins = "http://localhost:5173")
public class BusTripLogController {

    private final BusTripLogService busTripLogService;

    public BusTripLogController(BusTripLogService busTripLogService) {
        this.busTripLogService = busTripLogService;
    }

    @PutMapping("/{tripId}/end")
    public ResponseEntity<BusTripLogDto> endBusTrip(@PathVariable UUID tripId) {
        BusTripLogDto updatedLog = busTripLogService.endBusTrip(tripId);
        return new ResponseEntity<>(updatedLog, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BusTripLogDto> createBusTripLog(@RequestBody BusTripLogDto tripDto) {
        System.out.println(tripDto);
        BusTripLogDto savedTrip = busTripLogService.createBusTripLog(tripDto);
        System.out.println(savedTrip);
        return new ResponseEntity<>(savedTrip, HttpStatus.CREATED);
    }

}
