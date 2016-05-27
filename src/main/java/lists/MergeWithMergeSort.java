package lists;

/**
 * Created by gs on 2016-05-27.
 */
public class MergeWithMergeSort {

   static private class Node {
        public int data;
        public Node next;
       public Node() {}

        public Node(int data) {
            this.data = data;
        }

        public Node(int data,Node next) {
            this.data = data;
            this.next = next;
        }

    }

    public static Node mergeSort(Node input) {

        if(input.next == null) return input ;
        Node middle = getMiddleNode(input);


        Node l1 = input;
        Node l2 = middle.next;
        middle.next = null;

        System.out.print("l1=");
        print(l1);

        System.out.print("l2=");
        print(l2);

        return merge(mergeSort(l1), mergeSort(l2));
    }

    private static Node getMiddleNode(Node input) {
        Node slow = input;
        Node fast = input;

        while (fast.next != null) {

            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }

        return slow;
    }

    public static Node merge(Node left, Node right) {
        Node newHead = new Node();
        Node curr = newHead;

        Node currRight = left;
        Node currLeft = right;

        while (currLeft != null || currRight != null) {

            if (currLeft != null && currRight != null) {
                if (currLeft.data < currRight.data) {
                    curr.next = currLeft;
                    currLeft = currLeft.next;
                } else {
                    curr.next = currRight;
                    currRight = currRight.next;
                }
            curr = curr.next;

        }else if (currLeft == null) {
            curr.next = currRight;
                break;
        } else if (currRight == null) {
            curr.next = currLeft;
                break;
        }
    }

        System.out.print("merged: ");print(newHead.next);

        return newHead.next;

    }

    public static void append(Node head, int data) {
        Node newNode = new Node(data);
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public static void print(Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node l1 = new Node();
        Node l2 = new Node();

        for(int v : new int[] {1,5, 7}) {
            append(l1, v);
        }

        print(l1.next);

        for(int v : new int[] {2,3, 9}) {
            append(l2, v);
        }

        print(l2.next);

        print(merge(l1.next, l2.next));

        Node l3 = new Node();
        for(int v : new int[] {6,2,5, 1, 4, 2, 8, 3}) {
            append(l3, v);
        }

        print(l3.next);
        System.out.println("sorting begins");
        print(mergeSort(l3.next));
    }
}
