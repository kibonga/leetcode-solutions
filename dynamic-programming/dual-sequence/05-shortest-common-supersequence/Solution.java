class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];   // standard LCS table

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Reconstruct backward from (m, n), following the same logic used to fill the LCS table
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));   // common character: add it ONCE
                i--; j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                sb.append(str1.charAt(i - 1));   // character only from str1
                i--;
            } else {
                sb.append(str2.charAt(j - 1));   // character only from str2
                j--;
            }
        }
        while (i > 0) { sb.append(str1.charAt(i - 1)); i--; }   // remainder of str1 (if str2 was exhausted first)
        while (j > 0) { sb.append(str2.charAt(j - 1)); j--; }   // remainder of str2

        return sb.reverse().toString();
    }
}
