package stack;

import java.util.NoSuchElementException;


class LinkedStack {
    Node top;

    boolean isEmpty() {
        return top.getNext() == null;
    }

    String pop() {
        if (top != null) {
            String data = top.getData();
            top = top.getNext();
            return data;
        }

        throw new NoSuchElementException();
    }

    void push(String item) {
        Node newNode = new Node(item, top);
        top = newNode;
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
        LinkedStack stack = new LinkedStack();

            stack.push("I'm pushed first!");
            stack.push("hahaha");
            stack.push("mamama");
            stack.push("top");

            while(!stack.isEmpty()) {
                System.out.println(stack.pop());
            }

    }
}