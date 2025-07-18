package com.nowally.nowally_backend.mapper;

import com.nowally.nowally_backend.dto.RouteDto;
import com.nowally.nowally_backend.entity.Route;

public class RouteMapper {

    public static RouteDto toDto(Route route) {
        if (route == null) return null;

        RouteDto dto = new RouteDto();
        dto.setRouteId(route.getRouteId());
        dto.setListOfStoppings(route.getListOfStoppings());
        dto.setCreatedAt(route.getCreatedAt());

        return dto;
    }

    public static Route toEntity(RouteDto dto) {
        if (dto == null) return null;

        Route route = new Route();
        route.setRouteId(dto.getRouteId());
        route.setListOfStoppings(dto.getListOfStoppings());
        // Do not set createdAt manually — @PrePersist will handle it

        return route;
    }
}
