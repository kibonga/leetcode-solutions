class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);   // sentinel: n+1 is provably larger than any valid result (worst case: n ones)
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int square = 1; square * square <= i; square++) {
                dp[i] = Math.min(dp[i], dp[i - square * square] + 1);
            }
        }
        return dp[n];
    }
}
