class Solution {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        int[] dRow = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dCol = {-1, 1, -2, 2, -2, 2, -1, 1};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        int steps = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] cur = queue.poll();
                if (cur[0] == x && cur[1] == y) return steps;

                for (int d = 0; d < 8; d++) {
                    int nr = cur[0] + dRow[d], nc = cur[1] + dCol[d];
                    // bound: allow a small "overshoot" (-2) so BFS doesn't miss short shortcuts near the origin
                    if (nr < -2 || nc < -2 || nr > x + 2 || nc > y + 2) continue;
                    String key = nr + "," + nc;
                    if (visited.add(key)) queue.add(new int[]{nr, nc});
                }
            }
            steps++;
        }
        return -1; // theoretically unreachable in practice
    }
}
