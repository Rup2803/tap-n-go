package com.nowally.nowally_backend.mapper;

import com.nowally.nowally_backend.dto.MemberDto;
import com.nowally.nowally_backend.entity.Member;

public class MemberMapper {

    public static MemberDto mapToMemberDto (Member member) {
        if (member == null) {
            return null;
        }

        MemberDto dto = new MemberDto();
        dto.setMemberId(member.getMemberId());
        dto.setName(member.getName());
        dto.setEmail(member.getEmail());
        dto.setPhone(member.getPhone());
        dto.setPassword(member.getPassword());
        dto.setCreatedAt(member.getCreatedAt());

        return dto;
    }

    public static Member mapToMember(MemberDto dto) {
        if (dto == null) {
            return null;
        }

        Member member = new Member();
        member.setMemberId(dto.getMemberId()); // Only set if ID is externally controlled
        member.setName(dto.getName());
        member.setEmail(dto.getEmail());
        member.setPhone(dto.getPhone());
        member.setPassword(dto.getPassword());
        member.setCreatedAt(dto.getCreatedAt()); // Optional – normally set by entity logic

        return member;
    }
}

