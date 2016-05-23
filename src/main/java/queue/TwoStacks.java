package queue;

import lists.SinglyLinkedList;
import stack.Stack;

import java.util.NoSuchElementException;

/**
 * Created by gs on 2016-05-23.
 */
public class TwoStacks {

    private Stack a = new SinglyLinkedList();
    private Stack b = new SinglyLinkedList();


    public void enqueue(String s) {
        a.push(s);

    }

    public String dequeue() {
        while(!a.isEmpty()) {
            b.push(a.pop());
        }
        if(b.isEmpty()) {
            throw new NoSuchElementException();
        }
        return b.pop();
    }

    public static void main(String[] args) {
        TwoStacks s = new TwoStacks();
        s.enqueue("first");
        s.enqueue("second");
        s.dequeue(); //first removed
        s.enqueue("third");
        s.enqueue("fourth");

        System.out.println("1 " + s.dequeue());
        System.out.println("2 " + s.dequeue());
        System.out.println("3 " + s.dequeue());
    }
}
