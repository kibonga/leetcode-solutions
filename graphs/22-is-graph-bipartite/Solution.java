class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] groups = new int[graph.length];
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < graph.length; i++) {
            if (groups[i] == 0) {
                queue.add(i);
                groups[i] = -1;

                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    for (int neighbor : graph[current]) {
                        if (groups[neighbor] == groups[current]) {
                            return false;
                        } else if (groups[neighbor] == 0) {
                            groups[neighbor] = -groups[current];
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }

        return true;
    }
}
