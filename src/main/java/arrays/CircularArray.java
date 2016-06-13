package arrays;

import java.lang.reflect.Array;

/**
 * Created by gs on 2016-06-10.
 */
public class CircularArray<T> {

    T[] a;
    int front = 0;
    int rear = 0;
    int count = 0;
    Class<T> clazz;

    public CircularArray(Class<T> clazz, int size) {
        a = (T[])Array.newInstance(clazz, size);
        this.clazz = clazz;
    }

    public int size() {
        return (a.length - front + rear) % a.length;
    }

    public void add(T data) {
        System.out.println("size=" + size());
        if( size()-1 == a.length) {
            resize();
        }
        a[rear] = data;
        rear = (rear+1)% a.length;
    }

    private void resize() {
        System.out.println("resize");
        T[] tmp = (T[])Array.newInstance(clazz, 2*a.length);
        for(int i=0; i<count; i++) {
            tmp[i] = a[front];
            front = (front+1) % a.length;
        }
        front = 0;
        rear = count;
        a = tmp;
    }

    public T dequeue() {
        //check if empty TODO

        T result = a[front];
        a[front] = null;
        front = (front+1) %  a.length;
        count--;

        return result;
    }

    public static void main(String[] args) {
        CircularArray<Integer> q = new CircularArray<>(Integer.class, 2);
        q.add(1);
        q.add(2);
    }
}
