# Queues

## Terms

### Double-ended queue

dequeue (obsolate name)
deque (pron. deck)

Generalizes a queue, for which elements can be added to or removed from either the front (head) or back (tail).
It is also often called a head-tail linked list, though properly this refers to a specific data structure implementation

### Double-ended priority queue (***)
A double-ended priority queue (DEPQ) or double-ended heap.
s a data structure similar to a priority queue or heap, but allows for efficient removal of both the maximum and minimum,
according to some ordering on the keys (items) stored in the structure.
Every element in a DEPQ has a priority or value.
In a DEPQ, it is possible to remove the elements in both ascending as well as descending order.

## Standard API in Java


### Queue interface

Impl.       throws          special value
==========================================
Insert      add(e)          offer(e)
Remove      remove()        pool()
Examine     element()       peek()


## Most likely questions

TODO

http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/


A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. Following is an example:
The array is [1 3 -1 -3 5 3 6 7], and w is 3.

Input: A long array A[], and a window width w
Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
Requirement: Find a good optimal way to get B[i]

http://articles.leetcode.com/sliding-window-maximum/


- implement queue with two stacks which holds maximum.
- Use deque

Maximum in a Queue
 Question 93 Given an array of numbers and a sliding window size, how do you get the maximum numbers
in all sliding windows?
For example, if the input array is {2, 3, 4, 2, 6, 2, 5, 1} and the size of the sliding windows is 3, the output of
maximums are {4, 4, 6, 6, 6, 5}, as illustrated in Table 8-3.
www.



Circular array - Algorithm design and APplications page 57