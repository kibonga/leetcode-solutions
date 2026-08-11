class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];   // dp[i][j] = number of ways s[0..i) contains t[0..j) as a subsequence

        for (int i = 0; i <= m; i++) dp[i][0] = 1;   // empty t: exactly ONE way (choose nothing)

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];   // always valid: skip s[i-1], keep looking for a match further along
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];   // ADDITIONALLY: use this match too
                }
            }
        }
        return dp[m][n];
    }
}
