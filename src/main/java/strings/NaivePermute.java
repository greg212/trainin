package strings;

/**
 *
 * https://see.stanford.edu/materials/icspacs106b/H19-RecBacktrackExamples.pdf
 * Created by U200320 on 2016-06-15.
 */
public class NaivePermute {

    static void permute(String soFar, String rest) {
        if(rest.isEmpty()) {
            System.out.println(soFar);
        } else {
            for(int i=0; i<rest.length();i++) {
                System.out.println(rest.substring(0,i) + "|" + rest.substring(i+1) );
                //                               //begin end             // begin
                String remaining = rest.substring(0, i) + rest.substring(i+1);

                System.out.println(soFar + rest.charAt(i));
                System.out.println("----");
               // permute(soFar + rest.charAt(i), remaining);
            }
        }
    }

    public static void main(String[] args) {
        permute("", "abc");
    }
}
