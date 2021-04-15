package com.airline.airlineapp.controller;

import com.airline.airlineapp.dao.CrudResponse;
import com.airline.airlineapp.dao.Flight;
import com.airline.airlineapp.dao.FligthSearchRequest;
import com.airline.airlineapp.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/flight", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class FlightController {

  @Autowired
  private IFlightService flightService;

  @PostMapping("/define")
  public ResponseEntity<CrudResponse> defineFlight(@RequestBody Flight flight) {
    return ResponseEntity.ok(flightService.define(flight));
  }

  @PostMapping("/search")
  public ResponseEntity<List<Flight>> search(@RequestBody FligthSearchRequest fligthSearchRequest) {
    return ResponseEntity.ok(flightService.search(fligthSearchRequest));
  }

}
