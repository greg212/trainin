assignment 1)

http://www.geeksforgeeks.org/amazon-interview-set-9-answers/
-> http://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/


Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s.


Example
Input matrix
0 1 1 1
0 0 1 1
1 1 1 1  // this row has maximum 1s
0 0 0 0

Output: 2

Since each row is sorted, we can use modified Binary Search to count of 1s in each row. 
We find the index of first instance of 1 in each row. The count of 1s will be equal to total number of columns minus the index of first 1.