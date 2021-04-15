package com.airline.airlineapp.service.implementation;

import com.airline.airlineapp.dao.CrudResponse;
import com.airline.airlineapp.dao.Route;
import com.airline.airlineapp.model.AirportEntity;
import com.airline.airlineapp.model.RouteEntity;
import com.airline.airlineapp.repository.RouteRepository;
import com.airline.airlineapp.service.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RouteServiceImpl extends AbstactBasicService implements IRouteService {

  @Autowired
  private RouteRepository routeRepository;

  @Override
  public CrudResponse createRoute(Route route) {
    if (Objects.isNull(route)) {
      this.buildResponse(false);
    }
    boolean saved = this.saveRoute(route);

    return this.buildResponse(saved);
  }

  @Override
  public Route searchRoute(Long id) {
    Route route = new Route();
    if (Objects.nonNull(id) && id > 0) {
      RouteEntity routeEntity = routeRepository.findFirstByRouteId(id);
      AirportEntity comingFrom = routeEntity.getComingFrom();
      AirportEntity goingOn = routeEntity.getGoingOn();
      route.setEstimatedTime(routeEntity.getEstimatedTime());
    }

    return route;
  }

  private boolean saveRoute(Route route) {
    /*RouteEntity routeEntity = new RouteEntity();
    AirportEntity comingFrom () route;
    AirportEntity goingOn;
    routeEntity.setComingFrom(route.getComingFrom());
    routeEntity.setGoingOn(route.getGoingOn());
    routeEntity.setEstimatedTime(route.getEstimatedTime());
    routeRepository.save(routeEntity);
*/
    return true;
  }
}
