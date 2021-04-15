package com.airline.airlineapp.service;

import com.airline.airlineapp.dao.Airport;
import com.airline.airlineapp.dao.CrudRequest;
import com.airline.airlineapp.dao.CrudResponse;

import java.util.List;

public interface IAirportService {

  CrudResponse createAirport(Airport crudRequest);

  List<Airport> searchAirport(String name, String nation);

}
