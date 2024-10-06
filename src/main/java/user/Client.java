package user;

import interfaces.Printable;

public class Client extends User implements Printable {
    @Override
    public void printRole() {
        System.out.println("User role: client");
    }

    public void getTicket() {
        System.out.println("User is getting a ticket...");
    }
}
