package com.nowally.nowally_backend.repository;

import com.nowally.nowally_backend.entity.Card;
import com.nowally.nowally_backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {
    List<Card> findByMemberId(UUID memberId);
    Optional<Card> findByCardId(UUID cardId);
}
