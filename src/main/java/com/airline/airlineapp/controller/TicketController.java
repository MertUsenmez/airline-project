package com.airline.airlineapp.controller;

import com.airline.airlineapp.dao.FligthSearchRequest;
import com.airline.airlineapp.dao.Ticket;
import com.airline.airlineapp.dao.TicketSearchRequest;
import com.airline.airlineapp.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ticket", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class TicketController {

  @Autowired
  private ITicketService ticketService;

  @PostMapping("/buy")
  public ResponseEntity<Ticket> buy(@RequestBody Ticket ticket) {
    return ResponseEntity.ok(ticketService.buy(ticket));
  }

  @PostMapping("/cancel")
  public ResponseEntity<Ticket> cancel(@RequestBody Ticket ticket) {
    return ResponseEntity.ok(ticketService.cancel(ticket));
  }

  @PostMapping("/search")
  public ResponseEntity<Ticket> search(@RequestBody TicketSearchRequest searchRequest) {
    return ResponseEntity.ok(ticketService.search(searchRequest));
  }


}
