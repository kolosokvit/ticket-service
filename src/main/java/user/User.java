package user;

import utils.IdCounter;
import interfaces.Printable;

public class User implements Printable {
    private final int id = IdCounter.getId();

    public void printRole() {
        System.out.println("User role: user");
    }

    public int getId() {
        return id;
    }
}
