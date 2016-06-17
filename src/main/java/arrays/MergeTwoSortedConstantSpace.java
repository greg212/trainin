package arrays;

import java.util.Arrays;

/**
 *
 * http://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
 * Created by gs on 2016-05-26.
 */
public class MergeTwoSortedConstantSpace {

//    http://algs4.cs.princeton.edu/22mergesort/

//    Faster merge. Implement a version of merge() that copies the second half of a[] to aux[] in decreasing order and then does the merge back to a[]. This change allows you to remove the code to test that each of the halves has been exhausted from the inner loop. Note: the resulting sort is not stable.
//    private static void merge(Comparable[] a, int lo, int mid, int hi) {
//        for (int i = lo; i <= mid; i++)
//            aux[i] = a[i];
//
//        for (int j = mid+1; j <= hi; j++)
//            aux[j] = a[hi-j+mid+1];
//
//        int i = lo, j = hi;
//        for (int k = lo; k <= hi; k++)
//            if (less(aux[j], aux[i])) a[k] = aux[j--];
//            else
//
                // MergeWithMergeSort ar1[] and ar2[] with O(1) extra space
    static void merge(int ar1[], int ar2[] )
    {
        // Iterate through all elements of ar2[] starting from
        // the last element
        for (int i=ar2.length-1; i>=0; i--)
        {
        /* Find the smallest element greater than ar2[i]. Move all
           elements one position ahead till the smallest greater
           element is not found */
            int j, last = ar1[ar1.length-1];
            for (j=ar2.length-1; j >= 0 && ar1[j] > ar2[i]; j--)
                ar1[j+1] = ar1[j];

            // If there was a greater element
            if (j != ar2.length-1)
            {
                ar1[j+1] = ar2[i];
                ar2[i] = last;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = new int[] {1,5, 7, 11, 15, 16};
        int b[] = new int[] {8, 9, 10, 16, 17};

        merge(a, b);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

}
