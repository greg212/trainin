package stack;

import java.util.NoSuchElementException;


public class LinkedStack<T> {
    Node<T> top;

    public boolean isEmpty() {
        return top == null;
    }

    public T peek() {
        return top.getData();
    }

    public T pop() {
        if (top != null) {
            T data = top.getData();
            top = top.getNext();
            return data;
        }

        throw new NoSuchElementException();
    }

    public void push(T item) {
        Node<T> newNode = new Node<>(item, top);
        top = newNode;
    }

    static class Node<T> {
        T data;
        Node next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        T getData() {
            return data;
        }

        void setData(T data) {
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
        LinkedStack<Integer> stack = new LinkedStack<>();

            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);

            while(!stack.isEmpty()) {
                System.out.println(stack.pop());
            }

    }
}