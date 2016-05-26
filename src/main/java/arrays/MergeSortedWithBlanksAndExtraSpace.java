package arrays;

/**
 *
 * Merge an array of size n into another array of size m+n
 *
 * http://www.geeksforgeeks.org/merge-one-array-of-size-n-into-another-one-of-size-mn/
 *
 *
 * Created by gs on 2016-05-26.
 */
public class MergeSortedWithBlanksAndExtraSpace {

    static void moveTOEnd(Integer[] array) {

        int j=array.length-1;
        for(int i=array.length-1; i>=0; i--) {
            if(array[i] != null) {
                array[j] = array[i];
                j--;
            }
        }
    }

    static void merge2(Integer[] mPlusN, int[] N) {
        int i= N.length; //start in mPlusN
        int j=0; //index of N[]

        int k=0;

        while(j<=N.length) {
            if( i == (mPlusN.length) || mPlusN[i] > N[j]) {
                mPlusN[k]=N[j];
                k++; j++;
            } else if(mPlusN[i] <N[j]) {
                mPlusN[k]=mPlusN[i];
                k++; i++;
            }
        }
    }

    static void merge(Integer[] mPlusN, int[] n) {

        int startIndexMInPlusN = n.length;

        int outputIndex=0; //index of new array
        int idxPlusN =startIndexMInPlusN; //index into mPlusN
        int idxN=0; //index into n array
        while(outputIndex < (startIndexMInPlusN+n.length+1)) {
            System.out.print("outputIndex="+outputIndex + " ");

            if ( (idxN == n.length) || (idxPlusN <(mPlusN.length) && mPlusN[idxPlusN]<= n[idxN] )  ) {
                System.out.println( "idxN=" + idxN + " value=" + mPlusN[idxPlusN] + "index " + idxPlusN);
                mPlusN[outputIndex] = mPlusN[idxPlusN++];
                outputIndex++;
            } else{
                System.out.println("n array idxN=" + idxN);
                mPlusN[outputIndex] = n[idxN++];
                outputIndex++;
            }

        }

        System.out.println();
    }
    public static void main(String[] args) {
        Integer[] mPlusN = new Integer[] {2, null, 4, 12, 13, 17};
        int[] n = new int[] {1};//,3,5,15};

        System.out.println("size array " + mPlusN.length);
        moveTOEnd(mPlusN);

        for(Integer e : mPlusN) {
            System.out.print(e + " ");
        }
        System.out.println();

        merge(mPlusN, n);

        for(Integer e : mPlusN) {
            System.out.println(e + " ");
        }

    }
}
