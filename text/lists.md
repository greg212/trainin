# Linked lists

## Reverse a linked list.
*Write a function that takes the first Node in a linked list, reverse it, and returns the first Node in the resulting linked list.*

**Solution**

To accomplish this, we maintain references to three consecutive nodes in the linked list, reverse, first, and second.
At each iteration we extract the node first from the original linked list and insert it at the beginning of the reversed list.
We maintain the invariant that first is the first node of what's left of the original list,
second is the second node of what's left of the original list, and reverse is the first node of the resulting reversed list.

```
    public static Node reverse(Node list) {
       if (first == null || first.next == null) return first;
       Node first   = list;
       Node reverse = null;
       while (first != null) {
          Node second = first.next;
          first.next  = reverse;
          reverse     = first;
          first       = second;
       }
       return reverse;
    }
```

My solution:
```java
Node Reverse(Node head) {
    Node curr = head != null ? head.next : null;
    Node output = head;
    output.next = null;

    while(curr != null) {
        Node tmp = curr.next;

        curr.next = output;
        output = curr;
        curr = tmp;
    }
     //[0]->[1]->[2]->[3]->[4]->NULL

//insert front [0]
     //    insert front [1]

    return output;
}

```
```java
 // A simple and tail recursive function to reverse
    // a linked list.  prev is passed as NULL initially.
    Node reverseUtil(Node curr, Node prev) {

        /* If last node mark it head*/
        if (curr.next == null) {
            head = curr;

            /* Update next to prev node */
            curr.next = prev;
            return null;
        }

        /* Save curr->next node for recursive call */
        Node next1 = curr.next;

        /* and update next ..*/
        curr.next = prev;

        reverseUtil(next1, curr);
        return head;
    }
```

http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/

## Reverse a Linked List in groups of given size
*Given a linked list, write a function to reverse every k nodes (where k is an input to the function). *

Example:
Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3
Output:  3->2->1->6->5->4->8->7->NULL.

Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
Output:  5->4->3->2->1->8->7->6->NULL.

**Solution**

TODO
http://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/

## Mth-to-Last Element of a Singly Linked List

so we have two pointers. one is a iteration pointer and the other will be behind it by requested number of elements.
so for example lets say we need to get value of 3rd element from tail. we start incrementing second pointer after 3rd element alongside
 with iteration pointer.
When iteration pointer gets to the end(tail) second pointer is going to be pointing to 3rd element from it. which is our answer. hope that helps.

```java
int GetNode(Node head,int n) {

    Node posNode = head;
    Node nthFromTail = head;
    for(int i=0; i<n; i++) {
        posNode = posNode.next;
    }

    while(posNode.next != null) {
        posNode = posNode.next;
        nthFromTail = nthFromTail.next;
    }

    return nthFromTail.data;
}
```
**Solution**
	
	1) calculate size (n) of list - traverse, storing each node, checking is this end, if not use node's NEXT pointer 
	2) element = n - m - traverse
	
## Check for loop in linked list

**Solution**
Start slow pointer at the head of the list
Start fast pointer at second node
Loop infinitely

If the fast pointer reaches a null pointer
Return that the list is null terminated
If the fast pointer moves onto or over the slow pointer
Return that there is a cycle
Advance the slow pointer one node
Advance the fast pointer two nodes
```java
boolean hasCycle(Node head) {
    Node slow = head;
    Node fast = head;
    while(fast != null && slow != null) {
        slow = slow.next;
        if(fast.next != null) {
            fast  = fast.next.next;
        }
        if(fast == slow) return true;
    }

    return false;
}
```

## Find start node of loop in linked list
TODO

http://www.java2blog.com/2016/02/find-start-node-of-loop-in-linkedlist.html

## Check if the linked list is palindrome

**Solution**
 1   Find middle element of linked list using slow and fast pointer method .
 2   Reverse second part of linked list
 3   Compare first and second part of linked list if it matches then linked list is palindrome.

http://www.java2blog.com/2016/04/how-to-check-if-linked-list-is.html

## Rotate linked list

## Implement merge sort on lists

Recursive version, uses stack propotional to lenght

struct node* SortedMerge(struct node* a, struct node* b)
{
  struct node* result = NULL;

  /* Base cases */
  if (a == NULL)
     return(b);
  else if (b==NULL)
     return(a);

  /* Pick either a or b, and recur */
  if (a->data <= b->data)
  {
     result = a;
     result->next = SortedMerge(a->next, b);
  }
  else
  {
     result = b;
     result->next = SortedMerge(a, b->next);
  }
  return(result);
}F

## Merge Sort for Doubly Linked List
Similar to singly linked (only maintain prev poniter).
http://www.geeksforgeeks.org/merge-sort-for-doubly-linked-list/

## Merge two sorted lists using O(1) space

## Merge k sorted lists
simiar as for arrays (use prioriry queue)
https://techinterviewsolutions.net/2015/01/09/merge-sort/

## Find intersection of two sorted lists

TODO

## Write a function to get the intersection point of two Linked Lists.

TODO

http://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/

## Add two numbers represented by linked lists

TODO

http://www.geeksforgeeks.org/sum-of-two-linked-lists/


## Delete a node having this element in singly linked

Move data & next pointer from next node to the one which should be deleted

## Delete n nodes after m node of singly linked list

TODO

## Detect and remove loop in singly linked list

TODO

## Remove duplicates in unsorted list

http://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/

1) two loops (n^2)
2) merge sort fist, then traverse and remove dups nlogn
3) use hash table put, remove dups - n (linear assuming hash is O(1))

## Remove duplicates in sorted list

```java
Node RemoveDuplicates(Node head) {
    if(head == null) return null;

    Node curr = head;

    while(curr.next != null ) {
        if(curr.data == curr.next.data) {
            curr.next = curr.next.next;
        } else {
            curr = curr.next;
        }
    }

    return head;
}
```

## Find merge point of two lists

http://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/

```java
Node SortedInsert(Node head,int data) {

    if(head != null ) {
        Node curr = head;

        while(curr.next != null && curr.next.data < data) {

            curr = curr.next;
        }

        Node newNode = new Node();
        newNode.data = data;

        newNode.next = curr.next;
        if(newNode.next!=null) {
            newNode.next.prev = newNode;
        }
        curr.next = newNode;

        return head;
    } else {
        Node newNode = new Node();
        newNode.prev = null;
        newNode.data = data;

        return newNode;
    }
}
```

## Sort insert for cicular linked list
http://www.geeksforgeeks.org/sorted-insert-for-circular-linked-list/


## remove cycle from the linked list


## Reverse doubly linked
```java
Node Reverse(Node head) {
  Node curr = head;
    Node newHead = head;
    while (curr != null) {
        Node next = curr.next;
        curr.next = curr.prev;
        curr.prev = next;
        newHead = curr;  //important
        curr = next;
    }
    return newHead;
}
```
