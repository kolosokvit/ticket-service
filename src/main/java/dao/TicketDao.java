package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ticket.Ticket;

import java.util.List;

public class TicketDao {
    public void saveTicket(Ticket ticket) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(ticket);
        transaction.commit();
        session.close();
    }

    public Ticket getTicketById(int ticketId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Ticket ticket = session.get(Ticket.class, ticketId);
        session.close();
        return ticket;
    }

    public List<Ticket> getTicketByUserId(int userId) {
        List<Ticket> tickets;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        tickets = session.createQuery("FROM Ticket WHERE user.id = :user_id", Ticket.class)
                .setParameter("user_id", userId)
                .getResultList();
        session.close();
        return tickets;
    }

    public void updateTicket(Ticket ticket) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(ticket);
        transaction.commit();
        session.close();
    }
}
