package com.nowally.nowally_backend.service;

import com.nowally.nowally_backend.dto.TapLogDto;

public interface TapLogService {
    TapLogDto createTapLog(TapLogDto tapLogDto);
    TapLogDto updateTapLog(TapLogDto tapLogDto);
}
