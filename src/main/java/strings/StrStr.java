package strings;

/**
 * Created by U200320 on 2016-06-08.
 */
public class StrStr {

    public static int strstr(String haystack, String needle) {
        if(needle == null || haystack == null) {
            return -1;
        }

        if(needle.length()==0) {
            return 0;
        }

        if(needle.length()>haystack.length()){
            return -1;
        }

        final int maxPos = haystack.length()-needle.length();
        int start = 0;
        while(start <= maxPos) {
            boolean matches = true;
            for(int i=0;i<needle.length();i++) {
                if(haystack.charAt(start+i) != needle.charAt(i)) {
                    matches = false;
                    start++;
                    break;
                }
            }

            if(matches) {
                return start;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strstr("a", "a"));
        System.out.println(strstr("a", ""));
    }
}
