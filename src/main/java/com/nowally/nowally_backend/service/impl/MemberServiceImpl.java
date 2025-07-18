package com.nowally.nowally_backend.service.impl;

import com.nowally.nowally_backend.dto.MemberDto;
import com.nowally.nowally_backend.entity.Member;
import com.nowally.nowally_backend.mapper.MemberMapper;
import com.nowally.nowally_backend.repository.MemberRepository;
import com.nowally.nowally_backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements MemberService {


    @Autowired
    private MemberRepository memberRepository;

    @Override
    public MemberDto createMember(MemberDto memberDto) {

        Member member = MemberMapper.mapToMember(memberDto);
        Member savedMember = memberRepository.save(member);
        return MemberMapper.mapToMemberDto(savedMember);
    }

    @Override
    public MemberDto authenticateUser(MemberDto memberDto) {

        Member existingMember = memberRepository.findByEmail(memberDto.getEmail())
                .orElseThrow(() -> new RuntimeException("Oops looks like you ain't registered with us " + memberDto.getEmail()));

        if (!existingMember.getPassword().equals(memberDto.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // Step 3: Return DTO
        return MemberMapper.mapToMemberDto(existingMember);
    }
}
