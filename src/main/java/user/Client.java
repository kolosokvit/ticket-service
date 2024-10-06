package user;

public class Client extends User {
    @Override
    public void printRole() {
        System.out.println("User role: client");
    }

    public void getTicket() {
        System.out.println("User is getting a ticket...");
    }
}
