package arrays;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/rearrange-array-in-alternating-positive-negative-items-with-o1-extra-space-set-2/
 * <p>
 * Created by gs on 2016-05-27.
 */
public class AlteringPositiveNegativeItemsUnsorted {

    private static void rearrangeArray(int[] input) {

        if(input.length <= 2) {
            return;
        }

        int currentIndex = 1;
        int toSwapIndex = 2;

        while(toSwapIndex < input.length) {
            if(isDifferentSign(input, currentIndex -1, currentIndex)) {
                currentIndex++;
                toSwapIndex++;
            } else if (isDifferentSign(input, currentIndex, toSwapIndex)) {
                swap(input, currentIndex, toSwapIndex);
                currentIndex++;
            } else {
                toSwapIndex++;
            }
        }
    }

    private static boolean isDifferentSign(int[] array, int index1, int index2) {
        return isPositive(array[index1]) != isPositive(array[index2]);
    }

    // Assuming 0 is a positive number for this case
    private static boolean isPositive(final int number) {
        return number >= 0;
    }


    public static void main(String[] args) {

        int[] array = new int[]  {1, -3, 5, 7, -5, -1};
        
        rearrangeArray(array);

        System.out.println(Arrays.toString(array));
    }

    static void swap(int[] array, int a, int b) {
        int tmp;
        tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    private static void alternate(int[] array) {
        int front = -1;
        int back = array.length;

        while( front < back) {
            while(array[++front] > 0); // loop to first negative
            while(array[--back] <0); // loop to first positive from the back
            if(front < back )
                swap(array, front, back);
        }
    }
}
