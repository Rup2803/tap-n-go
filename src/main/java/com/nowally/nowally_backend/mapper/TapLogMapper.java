package com.nowally.nowally_backend.mapper;

import com.nowally.nowally_backend.dto.TapLogDto;
import com.nowally.nowally_backend.entity.TapLog;

public class TapLogMapper {

    public static TapLogDto mapToTapLogDto(TapLog tapLog) {
        return new TapLogDto(
                tapLog.getLogId(),
                tapLog.getNfcId(),
                tapLog.getTripId(),
                tapLog.getEntryStop(),
                tapLog.getExitStop(),
                tapLog.getCreatedAt()
        );
    }

    public static TapLog mapToTapLog(TapLogDto dto) {
        TapLog tapLog = new TapLog();
        tapLog.setLogId(dto.getLogId());
        tapLog.setNfcId(dto.getNfcId());
        tapLog.setTripId(dto.getTripId());
        tapLog.setEntryStop(dto.getEntryStop());
        tapLog.setExitStop(dto.getExitStop());
        tapLog.setCreatedAt(dto.getCreatedAt());
        return tapLog;
    }
}
