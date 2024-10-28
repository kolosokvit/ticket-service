package ticketservice.storages;

import java.util.ArrayList;
import java.util.List;

public class CustomHashSet<E> {
    private static final double LOAD_FACTOR = 0.75;
    private Object[] elements;
    private int size;
    private boolean isContainsNull;

    public CustomHashSet() {
        int initialCapacity = 5;
        this.elements = new Object[initialCapacity];
        this.size = 0;
        this.isContainsNull = false;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
       if (size == 0) {
           return "[]";
       } else {
           StringBuilder stringBuilder = new StringBuilder();
           stringBuilder.append("[");
           for (int i = 0; i < values().size(); i++) {
               if (values().get(i) == null) {
                   stringBuilder.append("null");
               } else {
                   stringBuilder.append(values().get(i).toString());
               }
               if (i + 1 == values().size()) {
                   stringBuilder.append("]");
               } else {
                   stringBuilder.append(", ");
               }
           }
           return stringBuilder.toString();
       }
    }

    public boolean add(E e) {
        if (contain(e)) {
            return false;
        } else {
            if (size > elements.length * LOAD_FACTOR) {
                rehash();
            }
            if (e == null) {
                elements[0] = null;
                isContainsNull = true;
            } else {
                while (elements[e.hashCode() % elements.length] != null) {
                    rehash();
                }
                elements[e.hashCode() % elements.length] = e;
            }
            size++;
            return true;
        }
    }

    private void rehash() {
        Object[] copy = new Object[elements.length * 2];
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] == null) {
                continue;
            }
            copy[elements[i].hashCode() % copy.length] = elements[i];
        }
        elements = copy;
    }

    public boolean contain(E e) {
        if (e == null) {
            return isContainsNull;
        } else {
            return elements[e.hashCode() % elements.length] != null && elements[e.hashCode() % elements.length].equals(e);
        }
    }

    public boolean delete(E e) {
        if (contain(e)) {
            if (e == null) {
                isContainsNull = false;
            } else {
                elements[e.hashCode() % elements.length] = null;
            }
            size--;
            return true;
        }
        return false;
    }

    public List<Object> values() {
        List<Object> list = new ArrayList<>();
        if (isContainsNull) {
            list.add(null);
        }
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] != null) {
                list.add(elements[i]);
            }
        }
        return list;
    }
}
