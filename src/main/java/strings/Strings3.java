package strings;

/**
 * Created by U200320 on 2016-05-19.
 */
public class Strings3 {

    public static String removeDups(char[] in) {
        int bitmast = 0;

        int k = 0;
        for(int pos =0 ; pos < in.length; pos++) {
            int bitpos = 1 << (in[pos] - 'a');
            if( (bitmast & bitpos) == 0) { //not a dup
                in[k++] = in[pos];
                bitmast |= bitpos;
            }
        }

        return new String(in, 0, k);
    }


    public static void main(String[] args) {
        String inputs[] = {"ble", "bae", "abba", "a", "", "aa", "aab"};

        for(String s : inputs) {
            System.out.println(s + "-uniq-" + removeDups(s.toCharArray()) );
        }
    }
}
