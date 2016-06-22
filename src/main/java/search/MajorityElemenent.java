package search;

/**
 * Created by gs on 2016-06-22.
 */
public class MajorityElemenent {

    static int majoriTyELement(int[] nums) {
        int count =0, ret =0;
        for(int num : nums) {
            if(count == 0) {
                ret =num;
            }

            if(num!=ret) {
                count --;
            } else {
                count ++;
            }
        }

        return ret;
    }
}
