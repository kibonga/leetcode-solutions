class Solution {
    public int minDeleteCost(String s1, String s2, int[] costs) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) dp[i][0] = dp[i - 1][0] + costs[s1.charAt(i - 1) - 'a'];
        for (int j = 1; j <= n; j++) dp[0][j] = dp[0][j - 1] + costs[s2.charAt(j - 1) - 'a'];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];   // match: free
                } else {
                    int deleteFromS1 = dp[i - 1][j] + costs[s1.charAt(i - 1) - 'a'];
                    int deleteFromS2 = dp[i][j - 1] + costs[s2.charAt(j - 1) - 'a'];
                    dp[i][j] = Math.min(deleteFromS1, deleteFromS2);
                }
            }
        }
        return dp[m][n];
    }
}
