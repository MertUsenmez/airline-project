package com.airline.airlineapp.service;

import com.airline.airlineapp.dao.FligthSearchRequest;
import com.airline.airlineapp.dao.Ticket;
import com.airline.airlineapp.dao.TicketSearchRequest;

public interface ITicketService {

  Ticket buy(Ticket ticket);

  Ticket cancel(Ticket ticket);

  Ticket search(TicketSearchRequest fligthSearchRequest);

}
