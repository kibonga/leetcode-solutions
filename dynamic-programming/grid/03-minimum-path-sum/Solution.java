class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (r == 0 && c == 0) continue;
                if (r == 0) {
                    dp[r][c] = dp[r][c - 1] + grid[r][c];       // first row: only from the left
                } else if (c == 0) {
                    dp[r][c] = dp[r - 1][c] + grid[r][c];       // first column: only from above
                } else {
                    dp[r][c] = Math.min(dp[r - 1][c], dp[r][c - 1]) + grid[r][c];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
