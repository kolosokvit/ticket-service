package user;

import utils.ClassIdCounter;
import interfaces.Printable;

public class Client extends User implements Printable {
    private static final int CLASS_ID = ClassIdCounter.getClassIdCounter();
    @Override
    public void printRole() {
        System.out.println("User role: client");
    }

    public void getTicket() {
        System.out.println("User is getting a ticket...");
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
