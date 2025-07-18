package com.nowally.nowally_backend.service.impl;

import com.nowally.nowally_backend.dto.TapLogDto;
import com.nowally.nowally_backend.entity.TapLog;
import com.nowally.nowally_backend.mapper.TapLogMapper;
import com.nowally.nowally_backend.repository.TapLogRepository;
import com.nowally.nowally_backend.service.TapLogService;
import com.nowally.nowally_backend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TapLogServiceImpl implements TapLogService {

    @Autowired
    private TapLogRepository tapLogRepository;

    @Autowired
    private TransactionService transactionService;


    @Override
    public TapLogDto createTapLog(TapLogDto tapLogDto) {
        TapLog tapLog = TapLogMapper.mapToTapLog(tapLogDto);
        TapLog savedTapLog = tapLogRepository.save(tapLog);
        return TapLogMapper.mapToTapLogDto(savedTapLog);
    }

    @Override
    public TapLogDto updateTapLog(TapLogDto tapLogDto) {
        String nfcId = tapLogDto.getNfcId();

        // Get the latest open tap log (exitStop is null)
        TapLog log = tapLogRepository
                .findTopByNfcIdAndExitStopIsNullOrderByCreatedAtDesc(nfcId)
                .orElseThrow(() -> new RuntimeException("No open tap log found for NFC ID: " + nfcId));

        // Update exit stop
        log.setExitStop(tapLogDto.getExitStop());

        // Save updated log
        TapLog updatedLog = tapLogRepository.save(log);

        // Convert to DTO (which will now contain tripId)
        TapLogDto updatedDto = TapLogMapper.mapToTapLogDto(updatedLog);

        // Call transaction service with updated DTO
        transactionService.createTransactionForPayment(updatedDto);

        return updatedDto;
    }




}
