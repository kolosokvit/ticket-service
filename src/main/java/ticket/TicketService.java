package ticket;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TicketService {
    private List<Ticket> ticketList = new ArrayList<>();
    
    public static void main(String[] args) {
        TicketService ticketService = new TicketService();
        
        final String CONCERT_HALL = "Arena";
        final String TICKET_PRICE = "500.55";

        ticketService.ticketList.add(new Ticket("0001", CONCERT_HALL, "111", LocalDateTime.of(2024, 11, 15, 20, 0),
                false, StadiumSector.A, 5.500, TICKET_PRICE));
        ticketService.ticketList.add(new Ticket("0002", CONCERT_HALL, "111", LocalDateTime.of(2024, 11, 15, 20, 0),
                false, StadiumSector.A, 5.500, TICKET_PRICE));
        ticketService.ticketList.add(new Ticket("0003", CONCERT_HALL, "111", LocalDateTime.of(2024, 11, 15, 20, 0),
                false, StadiumSector.A, 5.500, TICKET_PRICE));
        ticketService.ticketList.add(new Ticket("0004", CONCERT_HALL, "111", LocalDateTime.of(2024, 11, 15, 20, 0),
                false, StadiumSector.A, 5.500, TICKET_PRICE));
        ticketService.ticketList.add(new Ticket("0005", CONCERT_HALL, "111", LocalDateTime.of(2024, 11, 15, 20, 0),
                false, StadiumSector.A, 5.500, TICKET_PRICE));
        ticketService.ticketList.add(new Ticket("0006", CONCERT_HALL, "111", LocalDateTime.of(2024, 11, 15, 20, 0),
                false, StadiumSector.A, 5.500, TICKET_PRICE));
        ticketService.ticketList.add(new Ticket("0007", CONCERT_HALL, "111", LocalDateTime.of(2024, 11, 15, 20, 0),
                false, StadiumSector.A, 5.500, TICKET_PRICE));
        ticketService.ticketList.add(new Ticket("0008", CONCERT_HALL, "111", LocalDateTime.of(2024, 11, 15, 20, 0),
                false, StadiumSector.A, 5.500, TICKET_PRICE));
        ticketService.ticketList.add(new Ticket("0009", CONCERT_HALL, "111", LocalDateTime.of(2024, 11, 15, 20, 0),
                false, StadiumSector.A, 5.500, TICKET_PRICE));
        ticketService.ticketList.add(new Ticket("0010", CONCERT_HALL, "111", LocalDateTime.of(2024, 11, 15, 20, 0),
                false, StadiumSector.A, 5.500, TICKET_PRICE));

    }
}