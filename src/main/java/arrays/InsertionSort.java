package arrays;

/**
 * Created by gs on 2016-05-26.
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = new int[] {5, 1, 12, 5, 8, 9, 34, 5, 7,8};

        insertionSort2(array, 0, array.length);

        for (int c : array) {
            System.out.print(c + " ");
        }
    }

    public static void insertionSort(int[] array, int l, int size) {

        //if((size-l)<2) return;

        System.out.println("running insertion for "+(size-l));
        int j;
        for(int i=l+1;i<size; i++) {
            int newValue = array[i];
            j=i;
            while( j>l && array[j-1] > newValue) {
                array[j]=array[j-1];
                //swap(array, j, j-1);
                j--;
            }
            array[j]=newValue;
        }

        for(int i=l; i<size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void insertionSort2(int[] array, int l, int size) {

        //if((size-l)<2) return;

        System.out.println("running insertion for "+(size-l));
        int j;
        for(int i=l+1;i<size; i++) {
            j=i;
            while( j>l && array[j-1] > array[j]) {
                swap(array, j, j-1);
                j--;
            }
        }

        for(int i=l; i<size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static void swap(int[] array, int a, int b) {
        int tmp;
        tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
