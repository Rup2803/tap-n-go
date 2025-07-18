package com.nowally.nowally_backend.service.impl;

import com.nowally.nowally_backend.dto.PhoneDto;
import com.nowally.nowally_backend.dto.PhoneDto;
import com.nowally.nowally_backend.entity.Phone;
import com.nowally.nowally_backend.entity.Phone;
import com.nowally.nowally_backend.mapper.PhoneMapper;
import com.nowally.nowally_backend.mapper.PhoneMapper;
import com.nowally.nowally_backend.repository.PhoneRepository;
import com.nowally.nowally_backend.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public PhoneDto createPhone(PhoneDto phoneDto) {
        Phone phone = PhoneMapper.mapToPhone(phoneDto);
        Phone savedPhone = phoneRepository.save(phone);
        return PhoneMapper.mapToPhoneDto(savedPhone);
    }
    
    @Override
    public List<PhoneDto> getPhonesByNfcId(String nfcId) {
        System.out.println("Fetching phones for nfcId: " + nfcId);

        List<Phone> phones = phoneRepository.findByNfcId(nfcId);
        System.out.println("Fetched phones from DB: " + phones.size());

        for (Phone phone : phones) {
            System.out.println("Phone: " + phone); // Optional: Print phone details
        }

        List<PhoneDto> phoneDtos = phones.stream()
                .map(phone -> {
                    try {
                        return PhoneMapper.mapToPhoneDto(phone);
                    } catch (Exception e) {
                        System.out.println("Error mapping phone: " + phone);
                        e.printStackTrace();
                        throw e;
                    }
                })
                .collect(Collectors.toList());

        System.out.println("Successfully mapped all phones.");
        return phoneDtos;
    }
}
