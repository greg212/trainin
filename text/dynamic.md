# Dynamic & backtracking

## Edit distance

```java
class EditDistance {
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
}

```

## Permute string

```java
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
```

## Substring

```java
public class LongestCommonSubsequence {

    public static int getLongestCommonSubsequence(String a, String b){
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        for(int i=0;i<=a.length(); i++) {
            for(int j=0;j<=b.length();j++ ) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[m][n];
    }
```

## Coin change
```java

public class MinCoinChange {

    int getMinCount(int total, int[] coins) {
        int[] counts = new int[total + 1];
        counts[0] = 0;
        final int MAX = Integer.MAX_VALUE;
        for (int i = 1; i <= total; ++i) {
            int count = MAX;
            for (int j = 0; j < coins.length; ++j) {
                if (i - coins[j] >= 0 && count > counts[i - coins[j]])
                    count = counts[i - coins[j]];
            }
            if (count < MAX)
                counts[i] = count + 1;
            else
                counts[i] = MAX;
        }
        return counts[total];
    }


    int maxWay( int[] S, int m, int n)
    {
        int i, j, x, y;

        // We need n+1 rows as the table is consturcted in bottom up manner using
        // the base case 0 value case (n = 0)
        int[][] table = new int[n+1][m];

        // Fill the enteries for 0 value case (n = 0)
        for (i=0; i<m; i++)
            table[0][i] = 1;

        // Fill rest of the table enteries in bottom up manner
        for (i = 1; i < n+1; i++)
        {
            for (j = 0; j < m; j++)
            {
                // Count of solutions including S[j]
                x = (i-S[j] >= 0)? table[i - S[j]][j]: 0;

                // Count of solutions excluding S[j]
                y = (j >= 1)? table[i][j-1]: 0;

                // total count
                table[i][j] = x + y;
            }
        }
        return table[n][m-1];
    }
}

```

## Knight's tour

```java
// Java program for Knight Tour problem
class KnightTour {
    static int N = 8;

    /* A utility function to check if i,j are
       valid indexes for N*N chessboard */
    static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 &&
                y < N && sol[x][y] == -1);
    }

    /* A utility function to print solution
       matrix sol[N][N] */
    static void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

    /* This function solves the Knight Tour problem
       using Backtracking.  This  function mainly
       uses solveKTUtil() to solve the problem. It
       returns false if no complete tour is possible,
       otherwise return true and prints the tour.
       Please note that there may be more than one
       solutions, this function prints one of the
       feasible solutions.  */
    static boolean solveKT() {
        int sol[][] = new int[8][8];

        /* Initialization of solution matrix */
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;

       /* xMove[] and yMove[] define next move of Knight.
          xMove[] is for next value of x coordinate
          yMove[] is for next value of y coordinate */
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        // Since the Knight is initially at the first block
        sol[0][0] = 0;

        /* Start from 0,0 and explore all tours using
           solveKTUtil() */
        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            printSolution(sol);

        return true;
    }

    /* A recursive utility function to solve Knight
       Tour problem */
    static boolean solveKTUtil(int x, int y, int movei,
                               int sol[][], int xMove[],
                               int yMove[]) {
        int k, next_x, next_y;
        if (movei == N * N)
            return true;

        /* Try all next moves from the current coordinate
            x, y */
        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1,
                                sol, xMove, yMove))
                    return true;
                else
                    sol[next_x][next_y] = -1;// backtracking
            }
        }

        return false;
    }
```

