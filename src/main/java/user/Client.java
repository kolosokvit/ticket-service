package user;

import utils.IdCounter;
import interfaces.Printable;

public class Client extends User implements Printable {
    private final int id = IdCounter.getId();

    @Override
    public void printRole() {
        System.out.println("User role: client");
    }

    public void getTicket() {
        System.out.println("User is getting a ticket...");
    }

    @Override
    public int getId() {
        return id;
    }
}
