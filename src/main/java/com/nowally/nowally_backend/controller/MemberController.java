package com.nowally.nowally_backend.controller;


import com.nowally.nowally_backend.dto.MemberDto;
import com.nowally.nowally_backend.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/members")

public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<MemberDto> createMember(@RequestBody MemberDto memberDto) {
        MemberDto savedMember = memberService.createMember(memberDto);
        return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<MemberDto> authenticateUser(@RequestBody MemberDto memberDto) {
        MemberDto currUser = memberService.authenticateUser(memberDto);
        return new ResponseEntity<>(currUser, HttpStatus.OK);
    }
}
