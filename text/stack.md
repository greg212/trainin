======== Q1 single array to represent three stacks (CCI 5th 3.1)

Divide array in three parts;
calculate pointers
int[] stackPointer = {-I, -1, -I};

us a regular stack

======== Q2

======== Q3

How would you design a stack which, in addition to push and pop, also has a
function min which returns the minimum element? Push, pop and min should all
operate in 0(1) time

- putting additional var with min breaks constant time of pop - stack needs to be traversed

- use additional stack where min value is pushed; if value is popped and


====== Q4 (CCI 3.6)
Write a program to sort a stack in ascending order (with biggest items on top).
You may use at most one additional stack to hold items, but you may not copy the
elements into any other data structure (such as an array). The stack supports the
following operations: push, pop, peek, and isEmpty.

TODO ciekawe


Stacks in Java


Good stack explaination & assignments:
http://introcs.cs.princeton.edu/java/43stack/

dubljacy size stack array s

Interface Dequeue double ended queue


Deques can also be used as LIFO (Last-In-First-Out) stacks. This interface should be used in preference to the legacy Stack class. When a deque is used as a stack, elements are pushed and popped from the beginning of the deque. Stack methods are precisely equivalent to Deque methods as indicated in the table below:

Stack Method 	Equivalent Deque Method
push(e)            	addFirst(e)
pop()             	removeFirst()
peek() 	            peekFirst()



All Known Implementing Classes:
ArrayDeque, ConcurrentLinkedDeque, LinkedBlockingDeque, LinkedList


Linked lists usually allocate memory dynamically for each element. Depending on the overhead of
the memory allocator, these allocations are often more time consuming than the copies required by
a dynamic array, so a stack based on a dynamic array is usually faster than one based on a linked

Also caching


void push(E e)

Pushes an element onto the stack represented by this deque (in other words, at the head of this deque) if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.

This method is equivalent to addFirst(E).

Parameters:
    e - the element to push
Throws:
    IllegalStateException - if the element cannot be added at this time due to capacity restrictions
    ClassCastException - if the class of the specified element prevents it from being added to this deque
    NullPointerException - if the specified element is null and this deque does not permit null elements
    IllegalArgumentException - if some property of the specified element prevents it from being added to this deque
    
    
E pop()

Pops an element from the stack represented by this deque. In other words, removes and returns the first element of this deque.

This method is equivalent to removeFirst().

Returns:
    the element at the front of this deque (which is the top of the stack represented by this deque)
Throws:
    NoSuchElementException - if this deque is empty