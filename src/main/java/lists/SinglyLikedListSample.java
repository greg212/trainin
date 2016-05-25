package lists;


/**
 * Created by U200320 on 2016-05-20.
 */
public class SinglyLikedListSample  {

//merge two storted linked lists
    //inserton sort for lists (COding inerviews Q14)
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.appendTail("item1");
        list.appendTail("item2");
        list.appendFront("itemFront");
        list.appendTail("item3");
        list.appendFront("itemFront2");
        list.appendTail("item4");

        list.print_reverse();

        list.delete("item3");
        list.delete("itemFront2");

        list.insertBefore("itemFront", "itemFront_replaced1");
        list.insertBefore("itemFront", "itemFront_replaced2");
        list.insertBefore("item4", "itemFront_replaced3");

        System.out.println("tail: " + list.getTail().getData());
        list.insertAfter("item4", "insertedAtEnd");
        System.out.println("tail (should be inserterAtEnd: " + list.getTail().getData());
        list.delete("item1");
        System.out.println("tail (should be inserterdAtEnd: " + list.getTail().getData());
        list.delete("insertedAtEnd");
        System.out.println("tail (should be item4: " + list.getTail().getData());

        //list.appendHead(new SinglyLinkedList(null, "new head"));


        int pos = 0;
        for(SinglyLinkedList.Node node : list) {
            System.out.println("list el at " + pos + " value=" + node.getData());
            pos++;
        }

        System.out.println("Middle: " + list.findMiddle());
    }
}
