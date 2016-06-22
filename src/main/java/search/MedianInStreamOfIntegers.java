package search;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * http://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
 * https://gist.github.com/Vedrana/3675434
 * https://www.hackerrank.com/challenges/find-median-1
 *
 * Created by gs on 2016-06-22.
 */
public class MedianInStreamOfIntegers {
    static class MedianSink {

        Queue<Integer> min = new PriorityQueue<>();
        Queue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });

        void sink(int number) {
            if(min.size() > max.size()) {

                if(min.peek() > number) {
                    max.add(min.poll());
                    min.add(number);
                } else {
                    max.add(number);
                }
            } else if(min.size() < max.size()){

                if(max.peek() < number) {
                    min.add(max.poll());
                    max.add(number);
                } else
                {
                    min.add(number);
                }
            } else {
                if(min.isEmpty()) {
                    max.add(number);
                } else {
                    if(max.peek() < number) {
                        min.add(number);
                    } else {
                        max.add(number);
                    }
                }
            }
        }


        double getMedian() {
            if(max.size()> min.size()) {
                return max.peek();
            } else if(max.size() < min.size() ) {
                return min.peek();
            } else {
                return  (max.peek() + min.peek()) * 0.5;
            }
        }
    }

    final static String input = "10\n" +
            "1\n" +
            "2\n" +
            "3\n" +
            "4\n" +
            "5\n" +
            "6\n" +
            "7\n" +
            "8\n" +
            "9\n" +
            "10";


    public static void main(String[] args) {
        Scanner in = new Scanner(input/*System.in*/);
        int n = in.nextInt();
        MedianSink calc = new MedianSink();
        while(n-->0) {
            calc.sink(in.nextInt());
            System.out.println(calc.getMedian());
        }
        in.close();
    }
}
