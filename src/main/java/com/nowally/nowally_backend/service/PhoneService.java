package com.nowally.nowally_backend.service;

import com.nowally.nowally_backend.dto.PhoneDto;
import com.nowally.nowally_backend.entity.Phone;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface PhoneService {
    List<PhoneDto> getPhonesByNfcId(String nfcId);
    PhoneDto createPhone(PhoneDto phoneDto);
}
