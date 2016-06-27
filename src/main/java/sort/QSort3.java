package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/quicksort3
 * Created by U200320 on 2016-06-22.
 */
public class QSort3 {

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

        //System.out.println(Arrays.toString(a));

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

        printSub(a, 0, a.length-1);

        qsort(a, l, pi-1);

        qsort(a, pi+1, r);

    }

    static void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    private static int partition(int[] a,int l, int r) {
        int pivot = a[r];
        int k=l; //first larger than pivot
        for(int i=l; i<r;) {
            if(a[i] < pivot) {

                swap(a, i++, k++);
            } else {
                i++;
            }
        }

        swap(a, k, r);

        return k;
    }
}
