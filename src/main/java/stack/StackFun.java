package stack;

import lists.SinglyLinkedList;

/**
 * Created by U200320 on 2016-05-23.
 */
public class StackFun {

    public static void main(String[] args) {
        //testLinkedListImpl();
        testArrayStackImpl();
    }

    private static void testLinkedListImpl() {
        Stack stack = new SinglyLinkedList();


        stack.push("I'm pushed first!");
        stack.push("hahaha");
        stack.push("top!");

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        stack.pop();
    }

    private static void testArrayStackImpl() {
        Stack stack = new ArrayStack();


        stack.push("I'm pushed first!");
        stack.push("hahaha");
        stack.push("mamama");
        stack.push("mimimi");

        for(int i=0; i<40; i++) {
            stack.push("lololo "+ i);
        }
        stack.push("top!");

        System.out.println("correct order: top, hahaha, I'm pushed");
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

       // stack.pop();
    }
}
