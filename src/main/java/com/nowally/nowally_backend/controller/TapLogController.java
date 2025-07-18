package com.nowally.nowally_backend.controller;

import com.nowally.nowally_backend.dto.TapLogDto;
import com.nowally.nowally_backend.repository.TapLogRepository;
import com.nowally.nowally_backend.service.TapLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tap-logs")
@CrossOrigin(origins = "http://localhost:5173")

public class TapLogController {

    private final TapLogService tapLogService;

    public TapLogController(TapLogService tapLogService) {
        this.tapLogService = tapLogService;
    }

    @PostMapping
    public ResponseEntity<TapLogDto> createTapLog(@RequestBody TapLogDto tapLogDto) {
        TapLogDto savedTapLog = tapLogService.createTapLog(tapLogDto);
        return new ResponseEntity<>(savedTapLog, HttpStatus.CREATED);
    }

    @PostMapping("/exit")
    public ResponseEntity<TapLogDto> updateTapLog(@RequestBody TapLogDto tapLogDto) {
        TapLogDto updatedLog = tapLogService.updateTapLog(tapLogDto);

        //Call Service method of TransactionServiceImpl here

        return new ResponseEntity<>(updatedLog, HttpStatus.OK);
    }
}
