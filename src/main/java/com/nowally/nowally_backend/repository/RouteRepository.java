package com.nowally.nowally_backend.repository;

import com.nowally.nowally_backend.dto.RouteDto;
import com.nowally.nowally_backend.entity.Card;
import com.nowally.nowally_backend.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RouteRepository extends JpaRepository<Route, String> {
    List<Route> findByRouteId(String routeId);
    List<Route> findAll();
}
