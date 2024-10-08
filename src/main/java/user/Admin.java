package user;

import utils.IdCounter;
import interfaces.Printable;

public class Admin extends User implements Printable {
    private final int id = IdCounter.getId();

    @Override
    public void printRole() {
        System.out.println("User role: admin");
    }

    public void checkTicket() {
        System.out.println("Admin is checking a ticket...");
    }

    @Override
    public int getId() {
        return id;
    }
}
