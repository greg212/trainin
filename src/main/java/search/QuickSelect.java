package search;

import stack.ArrayStack;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/
 * Created by gs on 2016-05-30.
 */
public class QuickSelect {


    public static void qsort(int[] a) {
        qsort(a, 0, a.length-1);
    }

    public static void qsort(int[] a, int low, int high) {
        if(low < high) {
            int pi = partition(a, low, high);
            qsort(a, low, pi-1);
            qsort(a, pi+1, high);
        }
    }

    public static void swap(int[] a, int ai, int bi) {
        int tmp = a[ai];
        a[ai] = a[bi];
        a[bi] = tmp;
    }

    private static int partition(int[] a, int low, int high) {

        int pivot = a[high];

        int i = low-1;
        for(int j=low; j<high; j++) {
            if(a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, high, i+1);
        return i+1;
    }


    public static void main(String[] args) {
        int[] a = new int[] {4, 3, 1, 2, 7, 3};

//        qsort(a);
//        System.out.println(Arrays.toString(a));

        System.out.println( quickSelectKth(a, 0, a.length-1, 4) ); //FIXME does not work
    }

    private static int quickSelectKth(int[] a, int l, int r, int kth) {

        if( kth > 0 && kth <= (r-l +1) ) {
            int pivot = partition(a, l, r);

            if(pivot-l == kth-1) {
                return a[pivot];
            }

            if(pivot-l > kth) {
                return  quickSelectKth(a, l, pivot-1, kth);
            }
                return quickSelectKth(a, pivot+1, r, kth-pivot+l-1); //(kth - len(A) - Len(A2))

        }
        return Integer.MIN_VALUE;
    }

}
