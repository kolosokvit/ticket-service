package user;

import utils.ClassIdCounter;
import interfaces.Printable;

public class User implements Printable {
    private static final int CLASS_ID = ClassIdCounter.getClassIdCounter();
    public void printRole() {
        System.out.println("User role: user");
    }

    public int getClassId() {
        return CLASS_ID;
    }
}
