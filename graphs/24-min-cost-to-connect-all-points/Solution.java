class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] inMST = new boolean[n];
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));   // [index, cost]
        pq.add(new int[]{0, 0});

        int totalCost = 0, edgesUsed = 0;
        while (edgesUsed < n) {
            int[] cur = pq.poll();
            int u = cur[0], cost = cur[1];
            if (inMST[u]) continue;   // "ustajao" unos — u je već u stablu preko jeftinije ivice
            inMST[u] = true;
            totalCost += cost;
            edgesUsed++;

            for (int v = 0; v < n; v++) {
                if (!inMST[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                    pq.add(new int[]{v, dist});
                }
            }
        }
        return totalCost;
    }
}
