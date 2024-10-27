package ticket;

import dao.TicketDao;
import dao.UserDao;
import utils.IdCounter;
import interfaces.Printable;
import user.User;

import java.util.List;

public class TicketService implements Printable {
    private final int id = IdCounter.getId();

    public int getId() {
        return id;
    }

    public static void main(String[] args) {
        TicketDao ticketDao = new TicketDao();
        UserDao userDao = new UserDao();

        User user1 = new User();
        user1.setName("Alex");
        User user2 = new User();
        user2.setName("Bob");

        Ticket ticket1 = new Ticket();
        ticket1.setUser(user1);
        Ticket ticket2 = new Ticket();
        ticket2.setUser(user1);
        Ticket ticket3 = new Ticket();
        ticket3.setUser(user2);
        Ticket ticket4 = new Ticket();
        ticket4.setUser(user2);

        userDao.saveUser(user1);
        userDao.saveUser(user2);
        ticketDao.saveTicket(ticket1);
        ticketDao.saveTicket(ticket2);
        ticketDao.saveTicket(ticket3);
        ticketDao.saveTicket(ticket4);

        System.out.println(userDao.getUser(1));
        System.out.println(ticketDao.getTicketById(6).printTicketInfo());
        List<Ticket> tickets = ticketDao.getTicketByUserId(1);
        for (Ticket ticket : tickets) {
            System.out.println(ticket.printTicketInfo());
        }

        userDao.deleteUser(2);

        List<Ticket> ticketsForUpdate = ticketDao.getTicketByUserId(1);
        for (Ticket ticket : ticketsForUpdate) {
            ticket.setTicketType(TicketType.DAY);
            ticketDao.updateTicket(ticket);
        }
        List<Ticket> updatedTickets = ticketDao.getTicketByUserId(1);
        for (Ticket ticket : updatedTickets) {
            System.out.println(ticket.printTicketInfo());
        }
    }
}