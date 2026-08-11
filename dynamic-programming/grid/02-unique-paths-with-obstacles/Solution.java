class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (obstacleGrid[r][c] == 1) {
                    dp[r][c] = 0;   // obstacle: unreachable, regardless of the rest of the formula
                    continue;
                }
                if (r == 0 && c == 0) {
                    dp[r][c] = 1;
                } else {
                    int fromTop = (r > 0) ? dp[r - 1][c] : 0;
                    int fromLeft = (c > 0) ? dp[r][c - 1] : 0;
                    dp[r][c] = fromTop + fromLeft;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
