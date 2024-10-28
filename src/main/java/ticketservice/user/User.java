package ticketservice.user;

import ticketservice.utils.IdCounter;
import ticketservice.interfaces.Printable;

import java.time.LocalDateTime;

public class User implements Printable {
    private int id = IdCounter.getId();
    private String name;
    private LocalDateTime creationDate = LocalDateTime.now();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
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

    public void printRole() {
        System.out.println("User role: user");
    }
}


