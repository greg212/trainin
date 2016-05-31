package arrays;

/**
 * Created by gs on 2016-05-26.
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = new int[] {5, 1, 12, 5, 8, 9, 34, 5, 77,8};

        insertionCheck(array);

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

//    public static void sort(Comparable[] a) {
//        int N = a.length;
//        for (int i = 1; i < N; i++) {
//            for (int j = i; j > 0; j--) {
//                if (a[j-1].compareTo(a[j]) > 0) {
//                    swap(a, j-1, j);
//                }
//                else break;
//            }
//        }
//    }

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


    public static void insertionCheck(int[] a) {
        for(int i=1;i<a.length;i++) {
            int j=i;
            int newValue = a[i];
            while(j>0 && a[j-1] > newValue) {
                a[j]=a[j-1];
                j--;
            }

            a[j]=newValue;
        }
    }

    static void swap(int[] array, int a, int b) {
        int tmp;
        tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
