package com.airline.airlineapp.service.implementation;

import com.airline.airlineapp.dao.CrudResponse;
import com.airline.airlineapp.dao.Flight;
import com.airline.airlineapp.dao.FligthSearchRequest;
import com.airline.airlineapp.model.AirlineCompanyEntity;
import com.airline.airlineapp.model.FlightEntity;
import com.airline.airlineapp.repository.AirlineCompanyRepository;
import com.airline.airlineapp.repository.FlightRepository;
import com.airline.airlineapp.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FlightServiceImpl extends AbstactBasicService implements IFlightService {

  @Autowired
  private FlightRepository flightRepository;
  @Autowired
  private AirlineCompanyRepository airlineCompanyRepository;

  @Override
  public CrudResponse define(Flight flight) {
    boolean saved = false;

    if(Objects.nonNull(flight)) {
      try {
        FlightEntity flightEntity = new FlightEntity();
        flightEntity.setFlightCode(flight.getFlightCode());
        flightEntity.setFlightQuota(flight.getFlightQuota());
        flightEntity.setIsActive(1);
        flightEntity.setRouteEntity(flight.getRouteEntity());
        flightEntity.setAirlineCompanyEntity(flight.getAirlineCompanyEntity());
        flightRepository.save(flightEntity);
        saved = true;

      } catch (Exception ex) {

      }
      finally {
        this.buildFailResponse();
      }
    }
    return this.buildResponse(saved);
  }

  @Override
  public List<Flight> search(FligthSearchRequest fligthSearchRequest) {
    List<Flight> flights = new ArrayList<>();
    if (Objects.nonNull(fligthSearchRequest)) {
      Flight flight = new Flight();
      if (fligthSearchRequest.getFlightCode() != null) {
        FlightEntity flightEntity = flightRepository.findByFlightCodeAndIsActive(fligthSearchRequest.getFlightCode());
        if (Objects.nonNull(flightEntity)) {
          flight.setFlightId(flightEntity.getFlightId());
          flight.setFlightCode(flightEntity.getFlightCode());
          flight.setFlightQuota(flightEntity.getFlightQuota());
          flight.setRouteEntity(flightEntity.getRouteEntity());
          flight.setAirlineCompanyEntity(flightEntity.getAirlineCompanyEntity());
          flights.add(flight);
        }

      } else if (fligthSearchRequest.getAirlineCompanyName() != null) {
        List<AirlineCompanyEntity> airlineCompanyEntityList = airlineCompanyRepository.findByCompanyName(fligthSearchRequest.getAirlineCompanyName());
        for (AirlineCompanyEntity airlineCompanyEntity : airlineCompanyEntityList) {
          airlineCompanyEntity.getFlightEntityList().forEach(flightEntity -> {
            flight.setFlightId(flightEntity.getFlightId());
            flight.setFlightCode(flightEntity.getFlightCode());
            flight.setFlightQuota(flightEntity.getFlightQuota());
            flight.setRouteEntity(flightEntity.getRouteEntity());
            flight.setAirlineCompanyEntity(flightEntity.getAirlineCompanyEntity());
            flights.add(flight);
          });
        }
      }
    }

    return flights;
  }

}
