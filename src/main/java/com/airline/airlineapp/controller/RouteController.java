package com.airline.airlineapp.controller;

import com.airline.airlineapp.dao.CrudResponse;
import com.airline.airlineapp.dao.Route;
import com.airline.airlineapp.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/route", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class RouteController {

  @Autowired
  private IRouteService routeService;

  @PostMapping("/create")
  public ResponseEntity<CrudResponse> createAirlineCompany(@RequestBody Route route) {
    return ResponseEntity.ok(routeService.createRoute(route));
  }

  @GetMapping("/search/id")
  public ResponseEntity<Route> searchAirlineCompany(@PathVariable(value = "id") Long id) {
    return ResponseEntity.ok(routeService.searchRoute(id));
  }
}
