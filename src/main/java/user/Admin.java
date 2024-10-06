package user;

import interfaces.Printable;

public class Admin extends User implements Printable {
    @Override
    public void printRole() {
        System.out.println("User role: admin");
    }

    public void checkTicket() {
        System.out.println("Admin is checking a ticket...");
    }
}
