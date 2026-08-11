public int minimumSpanningForest(int n, int[][] pairs) {
    Arrays.sort(pairs, Comparator.comparingInt(p -> p[2])); // sort by fence length
    UnionFind uf = new UnionFind(n + 1); // 1-indexed (trees 1..n)

    int totalLength = 0;
    for (int[] pair : pairs) {
        int a = pair[0], b = pair[1], d = pair[2];
        if (uf.union(a, b)) {
            totalLength += d; // edge connected TWO different components — enters the forest
        }
    }
    return totalLength;
}

class UnionFind {
    private final int[] parent;

    UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    boolean union(int a, int b) {
        int rootA = find(a), rootB = find(b);
        if (rootA == rootB) return false; // already in the same component — this edge would create a cycle
        parent[rootA] = rootB;
        return true;
    }
}
