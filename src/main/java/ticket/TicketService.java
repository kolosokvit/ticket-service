package ticket;

public class TicketService {
    public static void main(String[] args) {
        Ticket emptyTicket = new Ticket();
        Ticket fullTicket = new Ticket("1111", "Stadium", "111", 1_727_802_000L, false, "A", 5.500, "500.554");
        Ticket limitedTicket = new Ticket("Arena", "222", 1_728_147_600L);
    }
}