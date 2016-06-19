package graphs;

import java.util.*;

/**
 * Created by gs on 2016-06-19.
 */
public class SnakesNladders {

    static final String input = "2\n" +
            "3\n" +
            "32 62\n" +
            "42 68\n" +
            "12 98\n" +
            "7\n" +
            "95 13\n" +
            "97 25\n" +
            "93 37\n" +
            "79 27\n" +
            "75 19\n" +
            "49 47\n" +
            "67 17\n" +
            "4\n" +
            "8 52\n" +
            "6 80\n" +
            "26 42\n" +
            "2 72\n" +
            "9\n" +
            "51 19\n" +
            "39 11\n" +
            "37 29\n" +
            "81 3\n" +
            "59 5\n" +
            "79 23\n" +
            "53 7\n" +
            "43 33\n" +
            "77 21 ";

    public static final String input2= "1\n" +
            "1\n" +
            "3 90\n" +
            "7\n" +
            "99 10\n" +
            "97 20\n" +
            "98 30\n" +
            "96 40\n" +
            "95 50\n" +
            "94 60\n" +
            "93 70";

    //output -1

    public static void main(String[] args) {
        Scanner in = new Scanner(input);

        int numTests = in.nextInt();

        final int MAX = 100;
        int[] moves = new int[MAX];



        for(int i=0; i<numTests; i++) {
            for (int k = 0; k<MAX; k++) {
                moves[k] = -1;
            }

            int numLadders = in.nextInt();
            for(int k=0;k<numLadders;k++) {
                moves[in.nextInt()-1] = in.nextInt()-1;
            }

            int numSnakes = in.nextInt();
            for(int k=0;k<numSnakes;k++) {
                moves[in.nextInt()-1] = in.nextInt()-1;
            }

            System.out.println(getMinDiceThrows(moves));
        }

        in.close();
    }

    private static int getMinDiceThrows(int[] moves) {
        boolean[] visited = new boolean[moves.length];
        for(int i =0;i<moves.length;i++ ) {
            visited[i] = false;
        }

        Queue<CellEntry> q = new ArrayDeque<>();
        visited[0] = true;
        q.add(new CellEntry(0,0));

        CellEntry answer = new CellEntry(-1, -1);
        while(!q.isEmpty()) {

            CellEntry ce = q.element();

            if(ce.v == (moves.length-1) ){
                answer = ce;
                break;
            }

            q.remove();
            for(int j=ce.v+1; j<=(ce.v+6) && j<moves.length;j++) {
                if(!visited[j]) {
                    CellEntry curr = new CellEntry(moves[j] != -1 ? moves[j] : j, ce.dist + 1);
                    visited[j] = true;

                    q.add(curr);
                }
            }


        }

        return answer.dist;
    }

    static class CellEntry {
        CellEntry(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
        int v;
        int dist;
    }
}
