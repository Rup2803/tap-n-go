package com.nowally.nowally_backend.service;

import com.nowally.nowally_backend.dto.MemberDto;

public interface MemberService {
    MemberDto createMember(MemberDto memberDto);
    MemberDto authenticateUser(MemberDto memberDto);
}