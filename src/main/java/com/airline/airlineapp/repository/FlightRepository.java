package com.airline.airlineapp.repository;

import com.airline.airlineapp.model.FlightEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface FlightRepository extends BaseJpaRepository<FlightEntity, Long> {

  FlightEntity findByFlightCodeAndIsActive(@RequestParam("flightCode") String flightCode);

}
