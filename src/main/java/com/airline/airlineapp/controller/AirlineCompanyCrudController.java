package com.airline.airlineapp.controller;

import com.airline.airlineapp.dao.AirlineCompany;
import com.airline.airlineapp.dao.CrudRequest;
import com.airline.airlineapp.dao.CrudResponse;
import com.airline.airlineapp.service.IAirlineCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/airline/company", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class AirlineCompanyCrudController {

  @Autowired
  private IAirlineCompanyService airlineCompanyCrud;

  @PostMapping("/create")
  public ResponseEntity<CrudResponse> createAirlineCompany(@RequestBody CrudRequest crudRequest) {
    return ResponseEntity.ok(airlineCompanyCrud.createAirlineCompany(crudRequest));
  }

  @GetMapping("/search")
  public ResponseEntity<List<AirlineCompany>> searchAirlineCompany(@RequestParam(value = "name") String name, @RequestParam(value = "nation") String nation) {
    return ResponseEntity.ok(airlineCompanyCrud.searchAirlineCompany(name, nation));
  }

}
