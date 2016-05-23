package strings;

import java.math.BigInteger;

/**
 * Created by U200320 on 2016-05-19.
 */
public class Strings1 {

    public static boolean isUniqueCharsAscii(String word) {
        int bitset = 0;
        for( char c : word.toCharArray()) {
            int delta = c - 'a';
            int bittest = 1 << delta;

            if( (bitset & bittest) > 0) {
                return false;
            }
            bitset |=  bittest;
        }
        return true;
    }

    public static boolean isUniqueCharsAscii2(String word) {
        BigInteger bitset = BigInteger.valueOf(0);
        for( char c : word.toCharArray()) {
            int delta = c - 'a';
            int bittest = 1 << delta;

            if( bitset.testBit(bittest)) {
                return false;
            }
            bitset = bitset.setBit(bittest);
        }
        return true;
    }


    public static void main(String[] args) {
        String inputs[] = {"ble", "blee", "a", "", "aa", "aab"};

        for(String s : inputs) {
            System.out.println(s + " " + (isUniqueCharsAscii2(s) ? "unique" : "some are duplicated"));
        }
    }
}
