package user;

import utils.ClassIdCounter;
import interfaces.Printable;

public class Admin extends User implements Printable {
    private static final int CLASS_ID = ClassIdCounter.getClassIdCounter();
    @Override
    public void printRole() {
        System.out.println("User role: admin");
    }

    public void checkTicket() {
        System.out.println("Admin is checking a ticket...");
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
