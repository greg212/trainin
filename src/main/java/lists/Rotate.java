package lists;

/**
 *
 * TODO make it more optimal
 *
 * Created by gs on 2016-05-27.
 */
public class Rotate {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.appendTail("item1");
        list.appendTail("item2");
        list.appendTail("item3");

        list.rotate(6);

        list.print(list.getHead().getNext());
    }
}
