package dynamic;

/**
 * Created by U200320 on 2016-06-16.
 */
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
