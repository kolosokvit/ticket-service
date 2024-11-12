package ticketservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ticketservice.model.Ticket;
import ticketservice.service.TicketService;

@RestController
public class TicketController {
  private final TicketService ticketService;

  public TicketController(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  @GetMapping("/tickets/{id}")
  Ticket getTicketById(@PathVariable int id) {
    return ticketService.getTicket(id);
  }
}
