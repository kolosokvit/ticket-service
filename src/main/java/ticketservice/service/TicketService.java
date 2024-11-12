package ticketservice.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import ticketservice.model.Ticket;
import ticketservice.model.TicketType;
import ticketservice.repository.TicketRepository;

@Service
public class TicketService {
  private final TicketRepository ticketRepository;

  public TicketService(TicketRepository ticketRepository) {
    this.ticketRepository = ticketRepository;
  }

  public Ticket saveTicket(Ticket ticket) {
    return ticketRepository.save(ticket);
  }

  public Ticket getTicket(int id) {
    Optional<Ticket> result = ticketRepository.findById(id);
    if (result.isPresent()) {
      return result.get();
    } else {
      throw new IllegalArgumentException("Can't find ticket with id: + id");
    }
  }

  public void deleteTicket(int id) {
    ticketRepository.deleteById(id);
  }

  public List<Ticket> getTicketsByUserId(int id) {
    return ticketRepository.getTicketsByUserId(id);
  }

  public Ticket updateTicketType(TicketType ticketType, int id) {
    return ticketRepository.updateTicketType(ticketType, id);
  }
}
