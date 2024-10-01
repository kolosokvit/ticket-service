package ticket;

import java.time.LocalDateTime;

public class TicketService {
    public static void main(String[] args) {
        Ticket emptyTicket = new Ticket();
        Ticket fullTicket = new Ticket("1111", "Stadium", "111", LocalDateTime.of(2024, 11, 15, 20, 00), false, "A", 5.500, "500.554");
        Ticket limitedTicket = new Ticket("Arena", "222", LocalDateTime.of(2024, 12, 31, 23, 00));
    }
}