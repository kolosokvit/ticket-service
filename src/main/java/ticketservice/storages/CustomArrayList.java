package ticketservice.storages;

import java.util.Arrays;

public class CustomArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int nextFreeIndex = 0;
    Object[] elements;
    private int size = 0;

    public CustomArrayList() {
        this.elements = new Object[] {};
    }

    public CustomArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elements = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elements = new Object[] {};
        } else {
            throw new IllegalArgumentException(String.format("Illegal capacity: %s", initialCapacity));
        }
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
            for (int i = 0; i < size; i++) {
                stringBuilder.append(elements[i].toString());
                if (i + 1 == size) {
                    stringBuilder.append("]");
                } else {
                    stringBuilder.append(", ");
                }
            }
            return stringBuilder.toString();
        }
    }

    public void add(E e) {
        checkCapacity();
        elements[nextFreeIndex] = e;
        nextFreeIndex++;
        size++;
    }

    public void delete(int index) {
        if (index < 0 || index >= nextFreeIndex) {
            throw new IllegalArgumentException(String.format("Illegal index for deleting: %s", index));
        }
        if (index == 0) {
            elements = Arrays.copyOfRange(elements, 1, elements.length);
        } else if (index == elements.length) {
            elements = Arrays.copyOfRange(elements, 0, elements.length - 1);
        } else {
            Object[] subArray1 = Arrays.copyOfRange(elements, 0, index);
            Object[] subArray2 = Arrays.copyOfRange(elements, index + 1, elements.length);
            elements = Arrays.copyOf(subArray1, subArray1.length + subArray2.length);
            System.arraycopy(subArray2, 0, elements, subArray1.length, subArray2.length);
        }
        nextFreeIndex--;
        size--;
    }

    public Object get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException(String.format("Illegal index for getting an element: %s", index));
        }
        return elements[index];
    }

    private void checkCapacity() {
        if (nextFreeIndex + 1 > elements.length) {
            if (elements.length == 0) {
                elements = new Object[DEFAULT_CAPACITY];
            } else {
                resize();
            }
        }
    }

    private void resize() {
        elements = Arrays.copyOf(elements, elements.length + elements.length / 2);
    }
}
