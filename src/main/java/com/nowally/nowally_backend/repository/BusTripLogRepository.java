package com.nowally.nowally_backend.repository;

import com.nowally.nowally_backend.entity.BusTripLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BusTripLogRepository extends JpaRepository<BusTripLog, UUID> {
    Optional<BusTripLog> findById(UUID tripId);
}
