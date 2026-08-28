class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        final int MOD = 1_000_000_007;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;   // 0 dice, sum 0 -> 1 way (empty choice)

        for (int dice = 1; dice <= n; dice++) {
            for (int face = 1; face <= k; face++) {           // sum over ALL choices, not take/skip
                for (int t = 1; t <= target; t++) {
                    if (t >= face) {
                        dp[dice][t] = (dp[dice][t] + dp[dice - 1][t - face]) % MOD;
                    }
                }
            }
        }

        return dp[n][target];
    }
}
