package strings;

/**
 * Created by U200320 on 2016-05-19.
 */
public class Strings2 {

    public static String reverse(String in) {
        StringBuilder builder = new StringBuilder(in);
        for(int i=0 ; i < in.length()/ 2; i++) {
            char swap = in.charAt(i);
            builder.setCharAt( i, in.charAt(in.length()-1-i) );
            builder.setCharAt( in.length()-1-i, swap);
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        String inputs[] = {"ble", "bae", "abba", "a", "", "aa", "aab"};

        for(String s : inputs) {
            System.out.println(s + "-" + reverse(s) );
        }
    }
}
