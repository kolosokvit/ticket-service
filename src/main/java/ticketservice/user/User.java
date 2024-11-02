package ticketservice.user;

import ticketservice.ticket.Ticket;
import ticketservice.utils.IdCounter;
import ticketservice.interfaces.Printable;

import java.time.LocalDateTime;
import java.util.List;

public class User implements Printable {
    private int id = IdCounter.getId();
    private String name;
    private LocalDateTime creationDate = LocalDateTime.now();
    private UserStatus userStatus;
    private List<Ticket> tickets;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void printRole() {
        System.out.println("User role: user");
    }
}


