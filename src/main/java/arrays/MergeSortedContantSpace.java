package arrays;

/**
 *
 * http://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
 * Created by gs on 2016-05-26.
 */
public class MergeSortedContantSpace {

    // Merge ar1[] and ar2[] with O(1) extra space
    void merge(int ar1[], int ar2[] )
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

}
