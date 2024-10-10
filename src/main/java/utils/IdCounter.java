package utils;

public abstract class IdCounter {
    private static int id = 0;

    private IdCounter() {
    }

    public static int getId() {
        return ++id;
    }
}
