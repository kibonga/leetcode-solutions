class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        dp[m][n - 1] = 1;   // sentinel boundary: "HP needed right AFTER the goal" = 1 (minimum allowed)
        dp[m - 1][n] = 1;   // sentinel boundary, the other side

        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                int needAfter = Math.min(dp[r + 1][c], dp[r][c + 1]);
                int needHere = needAfter - dungeon[r][c];
                dp[r][c] = Math.max(1, needHere);   // HP needed on entry is NEVER less than 1
            }
        }
        return dp[0][0];
    }
}
