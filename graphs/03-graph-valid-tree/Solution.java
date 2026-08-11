class Solution {
    public static boolean graphValidTree(int n, List<List<Integer>> edges) {
        if (edges.size() != n - 1) return false;   // necessary, not sufficient, condition — quick filter

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (var edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);   // undirected — BOTH directions required
        }

        boolean[] visited = new boolean[n];
        if (!isAcyclic(0, adjList, visited)) return false;

        for (var isVisited : visited) {
            if (!isVisited) return false;   // connectivity check
        }
        return true;
    }

    private static boolean isAcyclic(int start, List<List<Integer>> adjList, boolean[] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, -1});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int parent = current[1];

            for (int neighbor : adjList.get(node)) {
                if (neighbor == parent) continue;       // legitimate step back, not a cycle
                if (visited[neighbor]) return false;      // forms a cycle
                queue.add(new int[]{neighbor, node});
                visited[neighbor] = true;                 // mark WHEN ADDING to the queue
            }
        }
        return true;
    }
}
