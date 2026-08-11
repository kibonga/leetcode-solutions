class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (rooms[r][c] == 0) queue.add(new int[]{r, c});
            }
        }

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dRow[d], nc = cur[1] + dCol[d];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || rooms[nr][nc] != Integer.MAX_VALUE) continue;
                rooms[nr][nc] = rooms[cur[0]][cur[1]] + 1;
                queue.add(new int[]{nr, nc});
            }
        }
    }
}
