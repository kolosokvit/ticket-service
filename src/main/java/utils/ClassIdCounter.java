package utils;

public abstract class ClassIdCounter {
    private static int classIdCounter = 0;

    private ClassIdCounter() {
    }

    public static int getClassIdCounter() {
        return ++classIdCounter;
    }
}
