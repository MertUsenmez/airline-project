package com.airline.airlineapp.service;

import com.airline.airlineapp.dao.AirlineCompany;
import com.airline.airlineapp.dao.CrudRequest;
import com.airline.airlineapp.dao.CrudResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IAirlineCompanyService {

  CrudResponse createAirlineCompany(CrudRequest crudRequest);

  List<AirlineCompany> searchAirlineCompany(String name, String nation);

}
