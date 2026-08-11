class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxSide = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == '1') {
                    if (r == 0 || c == 0) {
                        dp[r][c] = 1;   // first row/column: max square side of 1
                    } else {
                        dp[r][c] = Math.min(dp[r - 1][c], Math.min(dp[r][c - 1], dp[r - 1][c - 1])) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[r][c]);
                }
                // matrix[r][c] == '0' -> dp[r][c] stays 0 (default), no square with a corner here
            }
        }
        return maxSide * maxSide;
    }
}
