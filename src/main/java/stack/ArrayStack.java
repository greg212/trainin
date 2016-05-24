package stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 *
 * In java we have implementation:
 * java.util.ArrayDeque<E>
 *
 * Created by U200320 on 2016-05-23.
 */
public class ArrayStack implements Stack{

    private final int INITIAL_SIZE = 2;

    private String[] storage;
    private int lastFree;

    public ArrayStack() {
        storage = new String[INITIAL_SIZE];
        lastFree = 0;
    }


    @Override
    public String pop() {

        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        return storage[--lastFree];
    }

    @Override
    public void push(String value) {
        storage[lastFree++] = value;

        if(lastFree>=storage.length) {
            System.out.println("----- resizing to: " + storage.length * 2);
            String[] newStorage = Arrays.copyOf(storage, storage.length * 2);
            storage = newStorage;
        }
    }

    @Override
    public boolean isEmpty() {
        return lastFree == 0;
    }
}
