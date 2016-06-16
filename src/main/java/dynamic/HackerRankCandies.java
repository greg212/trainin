package dynamic;

import math.Math;

import java.util.Arrays;

/**
 * Created by U200320 on 2016-06-15.
 */
public class HackerRankCandies {

    public static int solve(int[] rank, int a[]) {
        a[0] = 1;

        for(int i=1; i < rank.length; i++ ) {
            //a[i] = 1;
           if(rank[i] > rank[i-1]) {
               a[i] = a[i - 1] +1 ;
           } else
           {
               a[i] = 1;
           }
        }

        for(int i=rank.length-2; i>=0; i--) {
            if(rank[i]> rank[i+1]) {
                a[i] = java.lang.Math.max(a[i], a[i+1]+1);
            }
        }

        int sum=0;

        for(int i=0;i<a.length;i++) {
            sum += a[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] rank = new int[] {
                15944,
                91419,
                70351,
                71425,
                25893,
                25893};

        int[] a = new int[rank.length];

        solve(rank, a);


        System.out.println(Arrays.toString(a));
    }
}
