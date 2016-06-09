package arrays;


/**
 * Created by U200320 on 2016-06-08.
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] a = {1, -4, 6, 1, -3, 6};


        int max = getMaxSubarray(a);

        System.out.println();
        System.out.println("max:" + max);
    }

    private static int getMaxSubarray(int[] a) {
        int max = Integer.MIN_VALUE;

        for (int start = 0; start < a.length; start++) {
            int currSum = 0;
            for (int size = 1; size < a.length; size++) {
                if ((start + size) >= a.length) break;
                currSum += a[start+size];
//FIXME
                max = Math.max(currSum, max);
            }

        }
        return max;
    }

    private static int getMaxSubarrayNaive(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int size = 1; size < a.length; size++) {

            System.out.println();
            System.out.println("---" + size);
            for (int start = 0; start <= (a.length - size); start++) {
                int currSum = sum(a, start, start + size);
                if (max < currSum) {
                    max = currSum;
                }
            }

        }
        return max;
    }

    private static int sum(int[] a, int start, int lastIncluding) {
        //  System.out.println(start + "|" + size);
        int sum = 0;
        System.out.print("(");
        for (int i = start; i < lastIncluding; i++) {
            System.out.print(a[i] + " ");
            sum += a[i];
        }
        System.out.print(")");
        return sum;
    }
}
