class Solution {
    public int zombieInMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int humans = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) queue.add(new int[]{r, c});
                else humans++;
            }
        }

        if (humans == 0) return 0; // no one left to infect

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        int days = 0;

        while (!queue.isEmpty() && humans > 0) {
            int levelSize = queue.size(); // CURRENT day's zombies, frozen before the loop
            for (int i = 0; i < levelSize; i++) {
                int[] cur = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + dRow[d], nc = cur[1] + dCol[d];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != 0) continue;
                    grid[nr][nc] = 1;
                    humans--;
                    queue.add(new int[]{nr, nc});
                }
            }
            days++;
        }
        return humans == 0 ? days : -1;
    }
}
