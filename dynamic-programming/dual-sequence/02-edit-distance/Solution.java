class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) dp[i][0] = i;   // transform word1[0..i) into an empty string: i deletions
        for (int j = 0; j <= n; j++) dp[0][j] = j;   // transform an empty string into word2[0..j): j insertions

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];   // match: no cost, a "free" advance
                } else {
                    int delete = dp[i - 1][j];
                    int insert = dp[i][j - 1];
                    int replace = dp[i - 1][j - 1];
                    dp[i][j] = 1 + Math.min(delete, Math.min(insert, replace));
                }
            }
        }
        return dp[m][n];
    }
}
