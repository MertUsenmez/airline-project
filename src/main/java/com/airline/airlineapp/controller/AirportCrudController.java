package com.airline.airlineapp.controller;

import com.airline.airlineapp.dao.Airport;
import com.airline.airlineapp.dao.CrudRequest;
import com.airline.airlineapp.dao.CrudResponse;
import com.airline.airlineapp.service.IAirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/airport", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class AirportCrudController {

  @Autowired
  private IAirportService airportCrud;

  @PostMapping("/create")
  public ResponseEntity<CrudResponse> createAirport(@RequestBody Airport crudRequest) {
    return ResponseEntity.ok(airportCrud.createAirport(crudRequest));
  }

  @GetMapping("/search")
  public ResponseEntity<List<Airport>> searchAirport(@RequestParam(value = "name") String name, @RequestParam(value = "nation") String nation) {
    return ResponseEntity.ok(airportCrud.searchAirport(name, nation));
  }
}
