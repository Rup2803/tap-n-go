package com.nowally.nowally_backend.service.impl;

import com.nowally.nowally_backend.dto.RouteDto;
import com.nowally.nowally_backend.entity.Route;
import com.nowally.nowally_backend.repository.RouteRepository;
import com.nowally.nowally_backend.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public RouteDto getStoppingsByRouteId(String routeId) {

        List<Route> routes = routeRepository.findByRouteId(routeId);

        if (routes.isEmpty()) {
            return null; // or throw an exception
        }

        Route route = routes.get(0); // Take the first (or only) matching route

        return new RouteDto(
                route.getRouteId(),
                route.getListOfStoppings(),
                route.getCreatedAt()
        );
    }

    @Override
    public List<Route> findAll() {
        return routeRepository.findAll();
    }

}
