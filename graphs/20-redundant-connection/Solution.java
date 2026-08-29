class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int nodesCount = edges.length;
        var unionFind = new UnionFind(nodesCount);

        for (var edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (unionFind.findUltimateParent(x) == unionFind.findUltimateParent(y)) {
                return new int[] {x, y};
            }
            unionFind.union(x, y);
        }
        return null;   // unreachable given the problem's guarantee (there's always exactly one redundant edge)
    }

    public class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        public int findUltimateParent(int x) {
            if (parent[x] != x) {
                parent[x] = findUltimateParent(parent[x]);   // path compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int px = findUltimateParent(x);
            int py = findUltimateParent(y);
            if (px != py) parent[px] = py;
        }
    }
}
