package ticket;

import dao.TicketDao;
import dao.UserDao;
import storages.CustomArrayList;
import storages.CustomHashSet;
import utils.IdCounter;
import interfaces.Printable;
import user.Admin;
import user.Client;
import user.User;

import java.time.LocalDateTime;

public class TicketService implements Printable {
    private final int id = IdCounter.getId();

    public int getId() {
        return id;
    }

    public static void main(String[] args) {
        Ticket emptyTicket = new Ticket();
        Ticket fullTicket = new Ticket("Stadium", "111", LocalDateTime.of(2024, 11, 15, 20, 00), false, StadiumSector.A, 5.500, "500.554", TicketType.DAY);
        Ticket limitedTicket = new Ticket("Arena", "222", LocalDateTime.of(2024, 12, 31, 23, 00));

        fullTicket.share("+375291111111");
        fullTicket.share("+375291111111", "email@email.com");

        User admin = new Admin();
        User client = new Client();
        admin.printRole();
        client.printRole();

        CustomArrayList<Ticket> tickets = new CustomArrayList<>();
        tickets.add(emptyTicket);
        tickets.add(fullTicket);
        tickets.add(limitedTicket);
        System.out.println(tickets);
        System.out.println(tickets.get(0));
        tickets.delete(0);
        System.out.println(tickets);

        CustomHashSet<User> users = new CustomHashSet<>();
        users.add(admin);
        users.add(client);
        for (Object user : users.values()) {
            System.out.println(user);
        }
        users.delete(client);
        System.out.println(users.contain(client));

        TicketDao ticketDao = new TicketDao();
        UserDao userDao = new UserDao();
        Ticket ticket1 = new Ticket();
        ticket1.setId(1);
        ticket1.setTicketType(TicketType.MONTH);
        Ticket ticket2 = new Ticket();
        ticket2.setId(2);
        ticket2.setTicketType(TicketType.MONTH);
        User user = new User();
        user.setId(1);
        user.setName("Alex");
        userDao.saveUser(user);
        ticketDao.saveTicket(ticket1, user.getId());
        ticketDao.saveTicket(ticket2, user.getId());
        System.out.println(ticketDao.fetchTicketById(1));
        for (Ticket t : ticketDao.fetchTicketByUserId(user.getId())) {
            System.out.println(t);
        }
        ticketDao.updateTicketType(1, TicketType.YEAR);
    }
}