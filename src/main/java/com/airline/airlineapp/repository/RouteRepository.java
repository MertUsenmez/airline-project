package com.airline.airlineapp.repository;

import com.airline.airlineapp.model.RouteEntity;
import org.springframework.data.repository.query.Param;

public interface RouteRepository extends BaseJpaRepository<RouteEntity, Long> {

  RouteEntity findFirstByRouteId(@Param("routeId") Long routeId);
}
