package com.nowally.nowally_backend.service;

import com.nowally.nowally_backend.dto.RouteDto;
import com.nowally.nowally_backend.entity.Route;

import java.util.List;
import java.util.UUID;

public interface RouteService {
    List<Route> findAll();
    RouteDto getStoppingsByRouteId(String routeId);
}
