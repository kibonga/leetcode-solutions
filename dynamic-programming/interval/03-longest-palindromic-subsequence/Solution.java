class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];   // dp[l][r] = length of the longest palindromic subsequence in s[l..r]

        for (int i = 0; i < n; i++) dp[i][i] = 1;   // base case: a single character is a palindrome of length 1

        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                if (s.charAt(l) == s.charAt(r)) {
                    dp[l][r] = (len == 2) ? 2 : dp[l + 1][r - 1] + 2;
                } else {
                    dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
