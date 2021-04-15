package com.airline.airlineapp.repository;

import com.airline.airlineapp.model.AirlineCompanyEntity;
import com.airline.airlineapp.model.AirportEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AirportRepository extends BaseJpaRepository<AirportEntity, Long> {

  List<AirportEntity> findByAirportName(@Param("airportName") String airportName);
}
