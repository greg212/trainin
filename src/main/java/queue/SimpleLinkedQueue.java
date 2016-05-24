package queue;

import java.util.NoSuchElementException;



//  t ----------------------->
//     6   5   4    3   2  1
//     ^                   ^
//     Last                First

class SimpleLinkedQueue {

    Node first, last;

    void enqueue(String item) {
        Node newNode = new Node(item, last);
        last = newNode;
        if (first == null) {
            first = last;
        }
    }

    String dequeue() {
        if (first != null) {
            String data = first.getData();
            first = first.getNext();
            return data;
        }

        throw new NoSuchElementException();
    }

    static class Node {
        String data;
        Node next;

        Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        String getData() {
            return data;
        }

        void setData(String data) {
            this.data = data;
        }

        Node getNext() {
            return next;
        }

        void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        SimpleLinkedQueue s = new SimpleLinkedQueue();
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