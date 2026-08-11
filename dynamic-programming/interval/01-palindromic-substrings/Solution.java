class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];   // dp[l][r] = da li je s[l..r] palindrom
        int count = 0;

        for (int len = 1; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                if (s.charAt(l) != s.charAt(r)) {
                    dp[l][r] = false;
                } else {
                    dp[l][r] = (len <= 2) || dp[l + 1][r - 1];   // length 1/2: ends match => palindrome; otherwise check the inner range
                }
                if (dp[l][r]) count++;
            }
        }
        return count;
    }
}
