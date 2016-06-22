package sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/quicksort1
 * Created by U200320 on 2016-06-22.
 */
public class QSort2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(
            "7\n" +
            "5 8 1 3 7 9 2"
                /*System.in*/);

        int n = in.nextInt();

        int[] a = new int[n];
        for(int i=0;i<n;i++) {
            a[i] = in.nextInt();
        }

        qsort(a, 0, a.length-1);

       // System.out.println(Arrays.toString(a));

        in.close();
    }


    private static void printSub(int[] a, int l, int r) {
        int[] b = new int[r-l+1];
        System.arraycopy(a, l, b, 0, r-l+1);
        //System.out.print(Arrays.toString(b));
        for(int i=l; i<=r; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private static void qsort(int[] a, int l, int r) {
        if(r<=l) return;
        if((r-l+1)<2) return;

        int pi = partition(a, l, r);

        qsort(a, l, pi-1);

        qsort(a, pi+1, r);
        printSub(a, l, r);
    }

    private static int partition(int[] a,int l, int r) {

        int pivot = a[l];
        int[] lower = new int[a.length];
        int[] higher = new int[a.length];

        int k=0;
        int j=0;
        for(int i=l+1; i<=r; i++) {
            if(a[i]<pivot) {
                lower[k++] = a[i];
            } else {
                higher[j++] = a[i];
            }
        }

        int ii = l;
        for(int i=0; i<k; i++) {
            a[ii++] = lower[i];
        }
        int pi = ii;
        a[ii++] = pivot;

        for(int i=0; i<j; i++) {
            a[ii++] = higher[i];
        }

        return pi;
    }
}
