package storages;

import java.util.HashMap;
import java.util.Iterator;

public class CustomHashSet<E> {
    private static final Object PRESENT = new Object();
    private HashMap<E, Object> elements;

    public CustomHashSet() {
        elements = new HashMap<>();
    }

    @Override
    public String toString() {
        if (elements.isEmpty()) {
            return "[]";
        } else {
            Iterator<E> iterator = this.iterator();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            while (true) {
                stringBuilder.append(iterator.next().toString());
                if (!iterator.hasNext()) {
                    return stringBuilder.append("]").toString();
                } else {
                    stringBuilder.append(", ");
                }
            }

        }
    }

    public boolean add(E e) {
        if (!contains(e)) {
            elements.put(e, PRESENT);
            return true;
        }
        return false;
    }

    public boolean contains(E e) {
        return elements.containsKey(e);
    }

    public boolean delete(E e) {
        return elements.remove(e, PRESENT);
    }

    public Iterator<E> iterator() {
        return elements.keySet().iterator();
    }

    public int size() {
        return elements.size();
    }
}
