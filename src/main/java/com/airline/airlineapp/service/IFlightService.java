package com.airline.airlineapp.service;

import com.airline.airlineapp.dao.CrudResponse;
import com.airline.airlineapp.dao.Flight;
import com.airline.airlineapp.dao.FligthSearchRequest;

import java.util.List;

public interface IFlightService {

  CrudResponse define(Flight flight);

  List<Flight> search(FligthSearchRequest fligthSearchRequest);
}
