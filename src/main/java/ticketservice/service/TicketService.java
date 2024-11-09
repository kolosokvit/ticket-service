package ticketservice.service;

import org.springframework.stereotype.Service;
import ticketservice.model.Ticket;
import ticketservice.model.TicketType;
import ticketservice.repository.TicketRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void saveTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public Optional<Ticket> getTicket(int id) {
        return ticketRepository.findById(id);
    }

    public void deleteTicket(int id) {
        ticketRepository.deleteById(id);
    }

    public List<Ticket> getTicketsByUserId(int id) {
        return ticketRepository.getTicketsByUserId(id);
    }

    public int updateTicketType(TicketType ticketType, int id) {
        return ticketRepository.updateTicketType(ticketType, id);
    }
}
