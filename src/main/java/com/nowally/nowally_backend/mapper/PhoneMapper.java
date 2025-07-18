package com.nowally.nowally_backend.mapper;

import com.nowally.nowally_backend.dto.PhoneDto;
import com.nowally.nowally_backend.entity.Phone;

public class PhoneMapper {

    public static PhoneDto mapToPhoneDto(Phone phone) {
        PhoneDto dto = new PhoneDto();
        dto.setPhoneNumber(phone.getPhoneNumber());
        dto.setNfcId(phone.getNfcId());
        dto.setCardId(phone.getCardId());
        return dto;
    }

    public static Phone mapToPhone(PhoneDto dto) {
        Phone phone = new Phone();
        phone.setPhoneNumber(dto.getPhoneNumber());
        phone.setNfcId(dto.getNfcId());
        phone.setCardId(dto.getCardId());
        return phone;
    }
}
