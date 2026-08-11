class Solution {
    public int minCostToVisitEveryNode(int[][] graph) {
        int n = graph.length;
        int FULL = (1 << n) - 1;
        int[][] dp = new int[1 << n][n];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        dp[1][0] = 0;   // start: only node 0 visited, currently at node 0, cost 0

        for (int mask = 1; mask <= FULL; mask++) {
            for (int cur = 0; cur < n; cur++) {
                if ((mask & (1 << cur)) == 0 || dp[mask][cur] == Integer.MAX_VALUE) continue;   // cur must be in mask and reachable
                for (int next = 0; next < n; next++) {
                    if ((mask & (1 << next)) != 0) continue;   // next ALREADY visited
                    if (graph[cur][next] == 0) continue;        // no edge cur -> next
                    int newMask = mask | (1 << next);
                    dp[newMask][next] = Math.min(dp[newMask][next], dp[mask][cur] + graph[cur][next]);
                }
            }
        }

        int best = Integer.MAX_VALUE;
        for (int cur = 0; cur < n; cur++) {
            if (dp[FULL][cur] != Integer.MAX_VALUE) {
                best = Math.min(best, dp[FULL][cur]);
            }
        }
        return best == Integer.MAX_VALUE ? -1 : best;
    }
}
