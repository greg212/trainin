# Arrays

## Java API

length

int[] b = Arrays.copyOf(a, a.length); //array coping

Copies the specified array, truncating or padding with zeros (if necessary) so the copy has the specified length.

  int i = new Random().nextInt(maxExclusive)


assignment 2)

http://www.geeksforgeeks.org/amazon-interview-set-8-2/

3)     Given an array of size N, move the first d elements to its last.

e.g. {1, 2, 3, 4, 5}, d=2

    output: {3, 4, 5, 1, 2}


http://www.geeksforgeeks.org/array-rotation/



////A Juggling Algorithm
/*Fuction to get gcd of a and b*/
int gcd(int a,int b)
{
   if(b==0)
     return a;
   else
     return gcd(b, a%b);
}

/*Function to left rotate arr[] of siz n by d*/
void leftRotate(int arr[], int d, int n)
{
  int i, j, k, temp;
  for (i = 0; i < gcd(d, n); i++)
  {
    /* move i-th values of blocks */
    temp = arr[i];
    j = i;
    while(1)
    {
      k = j + d;
      if (k >= n)
        k = k - n;
      if (k == i)
        break;
      arr[j] = arr[k];
      j = k;
    }
    arr[j] = temp;
  }
}

////~A Juggling Algorithm

or O(n d)

void leftRotatebyOne(int arr[], int n)
{
  int i, temp;
  temp = arr[0];
  for (i = 0; i < n-1; i++)
     arr[i] = arr[i+1];
  arr[i] = temp;
}

/*Function to left rotate arr[] of size n by d*/
void leftRotate(int arr[], int d, int n)
{
  int i;
  for (i = 0; i < d; i++)
    leftRotatebyOne(arr, n);
}



 array todo

 http://www.geeksforgeeks.org/maximum-sum-path-across-two-arrays/


 https://www.careercup.com/question?id=5638261762424832


 TODO implement circular buffer

ASSIGNMENT 3
http://www.geeksforgeeks.org/count-all-distinct-pairs-formed-by-contiguous-sub-array/

Count distinct pairs in arrays of numbers (contiguous)
- sliding window
- number of pairs window size – 1
- expand window right
- if duplicate is found shrink window left until there are no duplicates
- store visited position in boolean vector

Input:  [1, 4, 2, 4, 3, 2]
Output: 8
The subarrays with distinct elements
are [1, 4, 2], [2, 4, 3] and [4, 3, 2].
There are 8 pairs that can be formed
from above array.
(1, 4), (1, 2), (4, 2), (2, 4), (2, 3),
(4, 3), (4, 2), (3, 2)


ASSIGNMENT 4
http://www.geeksforgeeks.org/absolute-distinct-count-array-sorted-absolute-values/


ASSIGNEMNT 5
http://www.geeksforgeeks.org/rearrange-array-in-alternating-positive-negative-items-with-o1-extra-space-set-2/

# Arrays

## Merge sort in array

TODO

## Merge two sorted arrays

TODO


## Merge K sorted arrays

1. Create an output array of size n*k.
2. Create a min heap of size k and insert 1st element in all the arrays into a the heap
3. Repeat following steps n*k times.
     a) Get minimum element from heap (minimum is always at root) and store it in output array.
     b) Replace heap root with next element from the array from which the element is extracted. If the array doesn’t have any more elements, then replace root with infinite. After replacing the root, heapify the tree.s


## Find duplicate element in array

### Using O(n) space
Use a HashSet to hold all numbers already seen. It operates in (amortized) O(1) time, so the total is O(N).

### Using constant space for two repeating numbers
http://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/

X + Y = S – n(n+1)/2
XY = P/n!

X + Y = 6
X – Y = 2

## Find duplicates in 0(n) time in O(1) extra space

http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
Use array elements as index (if you are allowed to modify array)

```java

void printRepeating(int arr[], int size)
{
  int i;

  printf("\n The repeating elements are");

  for(i = 0; i < size; i++)
  {
    if(arr[abs(arr[i])] > 0)
      arr[abs(arr[i])] = -arr[abs(arr[i])];
    else
      printf(" %d ", abs(arr[i]));
  }
}

```

## Find mode in an array (Most frequent number)

Given an array of size n, the array contains numbers in range from 0 to k-1 where k is a positive integer and k <= n.

A better approach is to create a count array of size k and initialize all elements of count[] as 0.

 Iterate through all elements of input array, and for every element arr[i],
 increment count[arr[i]]. Finally, iterate through count[] and return the index with maximum value. This approach takes O(n) time, but requires O(k) space.


Following is the O(n) time and O(1) extra space approach. Let us understand the approach with a simple example where arr[] = {2, 3, 3, 5, 3, 4, 1, 7}, k = 8, n = 8 (number of elements in arr[]).

1) Iterate though input array arr[], for every element arr[i], increment **arr[arr[i]%k]** by **k** (arr[] becomes {2, 11, 11, 29, 11, 12, 1, 15 })

2) Find the maximum value in the modified array (maximum value is 29). Index of the maximum value is the maximum repeating element (index of 29 is 3).

3) If we want to get the original array back, we can iterate through the array one more time and do **arr[i] = arr[i] % k** where i varies from 0 to n-1.

## Find majority element in an array

A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element).

findCandidate(a[], size)
1.  Initialize index and count of majority element
     maj_index = 0, count = 1
2.  Loop for i = 1 to size – 1
    (a)If a[maj_index] == a[i]
        count++
    (b)Else
        count--;
    (c)If count == 0
        maj_index = i;
        count = 1
3.  Return a[maj_index]

```c

/* Function to find the candidate for Majority */
int findCandidate(int a[], int size)
{
    int maj_index = 0, count = 1;
    int i;
    for(i = 1; i < size; i++)
    {
        if(a[maj_index] == a[i])
            count++;
        else
            count--;
        if(count == 0)
        {
            maj_index = i;
            count = 1;
        }
    }
    return a[maj_index];
}
/* Function to check if the candidate occurs more than n/2 times */
bool isMajority(int a[], int size, int cand)
{
    int i, count = 0;
    for (i = 0; i < size; i++)
      if(a[i] == cand)
         count++;
    if (count > size/2)
       return 1;
    else
       return 0;
}

```

## Search an element in a rotated sorted array

```

/* Searches an element key in a pivoted sorted array arrp[]
   of size n */
int pivotedBinarySearch(int arr[], int n, int key)
{
   int pivot = findPivot(arr, 0, n-1);

   // If we didn't find a pivot, then array is not rotated at all
   if (pivot == -1)
       return binarySearch(arr, 0, n-1, key);

   // If we found a pivot, then first compare with pivot and then
   // search in two subarrays around pivot
   if (arr[pivot] == key)
       return pivot;
   if (arr[0] <= key)
       return binarySearch(arr, 0, pivot-1, key);
   return binarySearch(arr, pivot+1, n-1, key);
}

/* Function to get pivot. For array 3, 4, 5, 6, 1, 2 it returns
   3 (index of 6) */
int findPivot(int arr[], int low, int high)
{
   // base cases
   if (high < low)  return -1;
   if (high == low) return low;

   int mid = (low + high)/2;   /*low + (high - low)/2;*/
   if (mid < high && arr[mid] > arr[mid + 1])
       return mid;
   if (mid > low && arr[mid] < arr[mid - 1])
       return (mid-1);
   if (arr[low] >= arr[mid])
       return findPivot(arr, low, mid-1);
   return findPivot(arr, mid + 1, high);
}

/* Standard Binary Search function*/
int binarySearch(int arr[], int low, int high, int key)
{
   if (high < low)
       return -1;
   int mid = (low + high)/2;  /*low + (high - low)/2;*/
   if (key == arr[mid])
       return mid;
   if (key > arr[mid])
       return binarySearch(arr, (mid + 1), high, key);
   return binarySearch(arr, low, (mid -1), key);
}

```


## Move all zeros to one end
1. maintain position counter; move nonzero items incrementing counter
2. fill rest with zeros

~~~java
static void MoveZeros(int[] a)
        {

            int i = 0;

            for (int j = 0; j < a.Length; j++)
                if (a[j] != 0)
                    a[i++] = a[j];

            while (i < a.Length)
                a[i++] = 0;

        }
~~~

    Dutch flag – move all 0s 1s 2s together
##Shuffle array

```
for i from n - 1 downto 1 do
       j = random integer with 0 <= j <= i
       exchange a[j] and a[i]
```

##Intersection of 2 sorted arrays

```

/* Function prints Intersection of arr1[] and arr2[]
   m is the number of elements in arr1[]
   n is the number of elements in arr2[] */
int printIntersection(int arr1[], int arr2[], int m, int n)
{
  int i = 0, j = 0;
  while (i < m && j < n)
  {
    if (arr1[i] < arr2[j])
      i++;
    else if (arr2[j] < arr1[i])
      j++;
    else /* if arr1[i] == arr2[j] */
    {
      printf(" %d ", arr2[j++]);
      i++;
    }
  }
}
```


    Find minimum element in rotated sorted array
    Rotate array left/right
##count occurrences in an array

###sorted array

1) Use Binary search to get index of the first occurrence of x in arr[]. Let the index of the first occurrence be i.
2) Use Binary search to get index of the last occurrence of x in arr[]. Let the index of the last occurrence be j.
3) Return (j – i + 1);

###unsorted array

1)  Subtract 1 from every element so that the elements
    become in range from 0 to n-1
    for (int j =0; j < n; j++)
        arr[j] = arr[j]-1;

2)  Use every element arr[i] as index and add 'n' to
    element present at arr[i]%n to keep track of count of
    occurrences of arr[i]
    for (int i=0; i < n; i++)
        arr[arr[i]%n] = arr[arr[i]%n] + n;

3)  To print counts, simply print the number of times n
    was added at index corresponding to every element
    for (int i =0; i < n; i++)
        print "(i + 1) -> arr[i] "


    2Sum
    3Sum
##Median of an array

TODO

###Median of two sorted arrays


##Sliding window maximum in a given array

http://articles.leetcode.com/sliding-window-maximum/

http://algorithmsandme.in/2014/03/heaps-sliding-window-algorithm/

http://tech-queries.blogspot.com/2011/05/sliding-window-maximum.html

    Maximum subarray problem
    Max and Min in an array
    Duplicate in an array
    Power of number


## optional

###Median of two sorted arrays
http://www.geeksforgeeks.org/median-of-two-sorted-arrays/


###Peak in given array
www.geeksforgeeks.org/find-a-peak-in-a-given-array/

```
 // A binary search based function that returns index of a peak
    // element
    static int findPeakUtil(int arr[], int low, int high, int n)
    {
        // Find index of middle element
        int mid = low + (high - low)/2;  /* (low + high)/2 */

        // Compare middle element with its neighbours (if neighbours
        // exist)
        if ((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == n-1 ||
             arr[mid+1] <= arr[mid]))
            return mid;

        // If middle element is not peak and its left neighbor is
        // greater than it,then left half must have a peak element
        else if (mid > 0 && arr[mid-1] > arr[mid])
            return findPeakUtil(arr, low, (mid -1), n);

        // If middle element is not peak and its right neighbor
        // is greater than it, then right half must have a peak
        // element
        else return findPeakUtil(arr, (mid + 1), high, n);
    }

    // A wrapper over recursive function findPeakUtil()
    static int findPeak(int arr[], int n)
    {
        return findPeakUtil(arr, 0, n-1, n);
    }

    ```

## other

### Merge two sorted arrays using O(1) space

```
Input: ar1[] = {1, 5, 9, 10, 15, 20};
       ar2[] = {2, 3, 8, 13};
Output: ar1[] = {1, 2, 3, 5, 8, 9}
        ar2[] = {10, 13, 15, 20}
```

http://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/

1) Iterate through every element of ar2[] starting from last
   element. Do following for every element ar2[i]
    a) Store last element of ar1[i]: last = ar1[i]
    b) Loop from last element of ar1[] while element ar1[j] is
       smaller than ar2[i].
          ar1[j+1] = ar1[j] // Move element one position ahead
          j--
    c) If any element of ar1[] was moved or (j != m-1)
          ar1[j+1] = ar2[i]
          ar2[i] = last

Find the missing number in duplicate array  - use XOR
http://www.geeksforgeeks.org/find-the-element-that-appears-once/
http://www.davismol.net/2014/03/01/amazon-interview-find-the-only-element-that-appears-an-odd-number-of-times-within-an-array-of-integers/


## Median in a stream of integers (running integers)
http://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/


W can use a max heap on left side to represent elements that are less than effective median, and a min heap on right side to represent elements that are greater than effective median.

After processing an incoming element, the number of elements in heaps differ utmost by 1 element.
When both heaps contain same number of elements, we pick average of heaps root data as effective median.

When the heaps are not balanced, we select effective median from the root of heap containing more elements.

Every time you insert, compare the new element with those at the top of the heaps in order to decide where to insert it.
If the new element is greater than the current median, it goes to the min-heap. If it is less than the current median, it goes to the max heap. Then you might need to rebalance. If the sizes of the heaps differ by more than one element, extract the min/max from the heap with more elements and insert it into the other heap.
