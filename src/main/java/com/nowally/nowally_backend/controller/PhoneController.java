package com.nowally.nowally_backend.controller;

import com.nowally.nowally_backend.dto.CardDto;
import com.nowally.nowally_backend.dto.PhoneDto;
import com.nowally.nowally_backend.entity.Phone;
import com.nowally.nowally_backend.mapper.PhoneMapper;
import com.nowally.nowally_backend.service.PhoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/phones")
@CrossOrigin(origins = "http://localhost:5173")
public class PhoneController {

    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @PostMapping
    public ResponseEntity<PhoneDto> createPhone(@RequestBody PhoneDto phoneDto) {
//        System.out.println(phoneDto);
        if (phoneDto.getPhoneNumber() == null || phoneDto.getPhoneNumber().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        PhoneDto savedPhone = phoneService.createPhone(phoneDto);
        return new ResponseEntity<>(savedPhone, HttpStatus.CREATED);
    }

    @GetMapping("/{nfcId}")
    public ResponseEntity<List<PhoneDto>> getPhonesByNfcId(@PathVariable String nfcId) {
        List<PhoneDto> phones = phoneService.getPhonesByNfcId(nfcId);
        return new ResponseEntity<>(phones, HttpStatus.OK);
    }
    

}