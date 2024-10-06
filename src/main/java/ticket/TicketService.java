package ticket;

import interfaces.Printable;
import user.Admin;
import user.Client;
import user.User;

import java.time.LocalDateTime;

public class TicketService implements Printable {
    public static void main(String[] args) {
        Ticket emptyTicket = new Ticket();
        Ticket fullTicket = new Ticket("1111", "Stadium", "111", LocalDateTime.of(2024, 11, 15, 20, 00), false, StadiumSector.A, 5.500, "500.554");
        Ticket limitedTicket = new Ticket("Arena", "222", LocalDateTime.of(2024, 12, 31, 23, 00));

        fullTicket.share("+375291111111");
        fullTicket.share("+375291111111", "email@email.com");

        User admin = new Admin();
        User client = new Client();
        admin.printRole();
        client.printRole();
    }
}