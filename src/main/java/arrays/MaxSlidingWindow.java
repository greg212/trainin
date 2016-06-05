package arrays;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 *
 * http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/
 *
 * http://algorithmsandme.in/2014/03/heaps-sliding-window-algorithm/
 *
 * Created by gs on 2016-06-04.
 */
public class MaxSlidingWindow {

    private static String str = "8 3\n"+
            "1  3  -1 3  5 3 6 7";

    public static void main(String[] args) {
        Scanner in = new Scanner(str);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }


        //incoming new higher value should erase oldest and lower entries
        for (int i = 0; i < m; i++) {
            int currStreamVal = arr[i];
            while(deque.peekLast() != null && currStreamVal >= arr[deque.peekLast()] ) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

          for(int i=m; i<n; i++ ) {

              System.out.println(arr[deque.peekFirst()] );

              while(deque.peekFirst() != null && deque.peekFirst() <= (i-m)) {
                  deque.pollFirst();
              }
              int currStreamVal = arr[i];

              while(deque.peekLast() != null && currStreamVal >= arr[deque.peekLast()] ) {
                  deque.pollLast();
              }
              deque.offerLast(i);
           }

        System.out.println(arr[deque.peekFirst()] );


    }
}
