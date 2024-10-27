package user;

import jakarta.persistence.*;
import utils.IdCounter;
import interfaces.Printable;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User implements Printable {
    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    private int id = IdCounter.getId();
    @Column(name = "name")
    private String name;
    @Column(name = "creation_date", nullable = false)
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


