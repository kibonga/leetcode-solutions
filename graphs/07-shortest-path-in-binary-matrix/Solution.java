class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;

        int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 1; // in-place mutation used as the visited marker

        int steps = 1; // the start cell counts as the first in the path
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // captured before the loop
            for (int i = 0; i < levelSize; i++) {
                int[] cur = queue.poll();
                if (cur[0] == n - 1 && cur[1] == n - 1) return steps;

                for (int d = 0; d < 8; d++) {
                    int nr = cur[0] + dRow[d], nc = cur[1] + dCol[d];
                    if (nr < 0 || nr >= n || nc < 0 || nc >= n || grid[nr][nc] != 0) continue;
                    grid[nr][nc] = 1;
                    queue.add(new int[]{nr, nc});
                }
            }
            steps++;
        }
        return -1;
    }
}
