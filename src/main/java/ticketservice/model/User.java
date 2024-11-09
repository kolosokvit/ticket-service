package ticketservice.model;

import jakarta.persistence.*;
import ticketservice.interfaces.Printable;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Printable {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate = LocalDateTime.now();
    @Column(name = "user_status")
    private UserStatus userStatus;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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


