package strings;

import java.lang.Math;

/**
 * Created by U200320 on 2016-06-16.
 */
public class EditDistance {

    static int editDistance(String x, String y) {
        int[][] d = new int[y.length()+1][x.length()+1];

        for(int i=0;i<=y.length(); ++i) {
            d[i][0] = i;
        }

        for(int i=0;i<=x.length(); ++i) {
            d[0][i] = i;
        }

        for(int i=1; i <= y.length(); ++i){
            for(int j=1; j<=x.length(); ++j) {
                if(x.charAt(i-1) == y.charAt(j-1)) {
                    d[i][j] = d[i-1][j-1];
                } else {
                    int deletion = d[i][j-1]+1;
                    int insertion = d[i-1][j]+1;
                    int substitution = d[i-1][j-1]+1;
                    d[i][j] = min(deletion, insertion, substitution);
                }
            }

        }

        return d[y.length()][x.length()];
    }

    static int min(int a, int b, int c) {
        return Math.min( Math.min(a,b), c);
    }
    public static void main(String[] args) {
        System.out.println(editDistance("ABA", "ABB"));
    }
}
