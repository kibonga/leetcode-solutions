class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        for (int i = 1; i <= strs.length; i++) {
            int numOfZeroes = 0;
            int numOfOnes = 0;
            for (char ch : strs[i - 1].toCharArray()) {
                if (ch == '0') numOfZeroes++;
                else numOfOnes++;
            }

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    int skip = dp[i - 1][j][k];
                    int take = 0;
                    if (j >= numOfZeroes && k >= numOfOnes) {
                        take = dp[i - 1][j - numOfZeroes][k - numOfOnes] + 1;
                    }
                    dp[i][j][k] = Math.max(skip, take);
                }
            }
        }

        return dp[strs.length][m][n];
    }
}
