package matrix;

/**
 * Created by gs on 2016-05-22.
 */
public class matrix_find_total_count_sorted {

    /*
    It is a modified binary search
     */
    static int bsearch(int row[], final int seekForValue) {
        int low = 0;
        int high = row.length -1;

        while (low <= high) {
            int mid = low + (((high - low)) / 2);
            if(row[mid] == seekForValue) {

                if( (mid == 0) || (mid-1)>=0 && row[mid-1] != seekForValue) {
                    return mid;
                } else {
                    high = mid -1;
                }
            }
            else if(row[mid]> seekForValue) {
                high = mid-1;
            } else if(row[mid]<seekForValue) {
                low = mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int m[][] =
                {
                        {0, 0, 1, 1, 1},
                        {0, 0, 0, 1, 1},
                        {1, 1, 1, 1, 1}
                };

                for(int row=0; row<m.length; row++) {
                    for (int v : m[row]) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

        for(int row=0; row<m.length; row++) {
            System.out.println("index of 1: " + bsearch(m[row], 1));
        }
    }
}
