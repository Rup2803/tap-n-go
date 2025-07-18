package com.nowally.nowally_backend.repository;

import com.nowally.nowally_backend.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, String> {
    Optional<Phone> findByCardId(String cardId);

    List<Phone> findByNfcId(String nfcId);
}
