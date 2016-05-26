package arrays;

/**
 *
 * http://www.geeksforgeeks.org/iterative-merge-sort/
 *
 * Created by gs on 2016-05-26.
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] array = new int[] {5, 1, 4, 8, 1, 5, 7, 7,3, 2, 1,18, 65, 34, 100};

        mergeSort(array, 0, array.length-1);

        for (int c : array) {
            System.out.print(c + " ");
        }
    }

    private static void mergeSort(int[] array, int l, int r) {
        if(l<r) {
            int m = (l + r ) / 2;
            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);

            InsertionSort.insertionSort2(array, l, r+1);
        }
    }
}
