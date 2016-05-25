package lists;

import java.util.NoSuchElementException;

import stack.Stack;

import java.util.Iterator;

/**
 * Created by U200320 on 2016-05-20.
 */
public class SinglyLinkedList implements Iterable<SinglyLinkedList.Node>, Stack {

   private Node head = new Node("head");

    //implement
    private Node tail = head;

    public String findMiddle() {
        Node slow = head.getNext();
        Node fast = head.getNext();

        while(fast.getNext() != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }

        return slow.getData();
    }

    Node getTail() {
       return tail;
    }

    public static SinglyLinkedList merge(SinglyLinkedList l1, SinglyLinkedList l2) {
        SinglyLinkedList newList = new SinglyLinkedList();
        Node newNodes = newList.getHead();

        Node nodes1 = l1.getHead();

//        while(nodes1.getNext()!=null) {
//            newNodes.set
//        }
        return newList;
    }

    //TODO implement kth node from the end

    public void print_reverse() {
        print(head.getNext());

    }

    public void print(Node currNode) {
        if(currNode != null) {
            print(currNode.getNext());
            System.out.println(currNode.getData());
        }
    }

    //TODO implmenent
    public void insertAfter(String search, String newData) {
        Node current = head.getNext();
        while (current!=null && !current.getData().equals(search)) {
            current = current.getNext();
        }

        if(current !=null && current.getData().equals(search) ) {
            Node newNode = new Node(newData, current.getNext());
            current.setNext(newNode);

            //are this last item?
            if(newNode.getNext() == null) {
                tail = newNode;
            }
        }
    }

    //edge case: insert on head
    public void insertBefore(String search, String newData) {
        Node prev = head;
        Node current = head.getNext();

        while(current != null && !current.getData().equals(search)) {
            prev = current;
            current = current.getNext();
        }

        if(current != head && current != null && current.getData().equals(search)) {
            Node newNode = new Node(newData, current);
            prev.setNext(newNode);
        }
    }

    public void delete(String element) {
        Node prev = head;
        Node current = head.getNext();

        while(current != null) {
            //current will be deleted
            if(current.getData().equals(element)) {
                prev.setNext(current.getNext());
                if(prev.getNext() == null) {
                    tail = prev;
                }
                break;
            }
            prev = current;
            current = current.getNext();
        }
    }


    public void appendTail(String data) {
        Node newNode = new Node(data);

        Node next = head;
        while(next.getNext() != null) {
            next = next.getNext();
        }
        next.setNext(newNode);
        tail = newNode;
    }

    public void appendFront(String data) {
        Node newNode = new Node(data, head.getNext());
        head.setNext(newNode);
        if(newNode.getNext() == null) {
            tail = newNode;
        }
    }

    public String pop() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }

        Node first = head.getNext();

        head.setNext(first.getNext());

        return first.getData();
    }

    public void push(String value) {
        appendFront(value);
    }

    public boolean isEmpty() {
        return getHead().getNext() == null;
    }

    @Override
    public Iterator<Node> iterator() {

        Iterator<Node> it = new Iterator<Node>() {
            Node current = head;

            public boolean hasNext() {
                return current.getNext() != null;
            }

            public Node next() {
                current = current.getNext();
                return current;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

        return it;

    }

    public Node getHead() {
        return head;
    }

    public class Node {
        private String data;
        private Node next;

        public Node(String data) {
            this.data = data;
        }

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
