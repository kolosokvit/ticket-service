package ticketservice.ticket;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ticketservice.TicketServiceApplicationContext;
import ticketservice.dao.TicketDao;
import ticketservice.dao.UserDao;
import ticketservice.storages.CustomArrayList;
import ticketservice.storages.CustomHashSet;
import ticketservice.utils.IdCounter;
import ticketservice.interfaces.Printable;
import ticketservice.user.Admin;
import ticketservice.user.Client;
import ticketservice.user.User;

import java.time.LocalDateTime;
import java.util.List;

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

        ApplicationContext appContext = new AnnotationConfigApplicationContext(TicketServiceApplicationContext.class);
        TicketDao ticketDao = appContext.getBean(TicketDao.class);
        UserDao userDao = appContext.getBean(UserDao.class);
        User user = new User();
        user.setName("Alex");
        userDao.saveUser(user);
        Ticket ticket1 = new Ticket();
        ticket1.setTicketType(TicketType.MONTH);
        Ticket ticket2 = new Ticket();
        ticket2.setTicketType(TicketType.DAY);
        ticketDao.saveTicket(ticket1, user.getId());
        ticketDao.saveTicket(ticket2, user.getId());
        userDao.activateUser(8, TicketType.YEAR);
        TicketDataReader ticketDataReader = appContext.getBean(TicketDataReader.class);
        List<String> ticketList = ticketDataReader.loadTicketDataFromResources();
        for (String s : ticketList) {
            System.out.println(s);
        }
    }
}