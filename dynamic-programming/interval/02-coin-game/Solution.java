class Solution {
    public boolean predictTheWinner(int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][n];   // dp[l][r] = max DIFFERENCE (current player - opponent) over remaining coins[l..r]

        for (int i = 0; i < n; i++) dp[i][i] = coins[i];   // base case: only one coin, it must be taken

        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                int takeLeft = coins[l] - dp[l + 1][r];    // take the left one, opponent plays [l+1, r] from THEIR perspective
                int takeRight = coins[r] - dp[l][r - 1];   // take the right one, opponent plays [l, r-1]
                dp[l][r] = Math.max(takeLeft, takeRight);
            }
        }
        return dp[0][n - 1] >= 0;   // non-negative difference => the first player guarantees AT LEAST a tie (or better)
    }
}
