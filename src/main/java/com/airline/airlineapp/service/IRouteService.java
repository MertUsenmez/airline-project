package com.airline.airlineapp.service;

import com.airline.airlineapp.dao.AirlineCompany;
import com.airline.airlineapp.dao.CrudRequest;
import com.airline.airlineapp.dao.CrudResponse;
import com.airline.airlineapp.dao.Route;

import java.util.List;

public interface IRouteService {

  CrudResponse createRoute(Route route);

  Route searchRoute(Long id);
}
