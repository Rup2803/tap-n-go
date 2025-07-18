package com.nowally.nowally_backend.controller;

import com.nowally.nowally_backend.dto.RouteDto;
import com.nowally.nowally_backend.entity.Route;
import com.nowally.nowally_backend.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/routes")

public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public ResponseEntity<List<Route>> getRoutes() {
        List<Route> routes = routeService.findAll();
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    @GetMapping("/{routeId}")
    public ResponseEntity<RouteDto> getStoppingsByRouteId(@PathVariable String routeId) {
        RouteDto routeDto = routeService.getStoppingsByRouteId(routeId);
        return new ResponseEntity<>(routeDto, HttpStatus.OK);
    }
}
