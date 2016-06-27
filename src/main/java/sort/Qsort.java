package sort;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/quicksort1
 * Created by U200320 on 2016-06-22.
 */
public class Qsort {

    public static void main(String[] args) {
        Scanner in = new Scanner("6\n" +
                "2 5 4 3 7 1"
                /*System.in*/);

        int n = in.nextInt();

        int[] a = new int[n];
        for(int i=0;i<n;i++) {
            a[i] = in.nextInt();
        }

        partition(a);

        in.close();
    }

    private static void partition(int[] a) {
        int pivot = a[0];
        int[] lower = new int[a.length];
        int[] higher = new int[a.length];

        int k= 0;
        int j=0;
        for(int i=1; i<a.length; i++) {
            if(a[i]<=pivot) {
                lower[k++] = a[i];
            } else {
                higher[j++] = a[i];
            }
        }

        for(int i=0; i<k; i++) {
            System.out.print(lower[i] + " ");
        }
        System.out.print(pivot + " ");
        for(int i=0; i<j; i++) {
            System.out.print(higher[i] + " ");
        }
    }
}
