class Solution {
    public boolean sequenceReconstruction(int[] original, List<List<Integer>> sequences) {
        int n = original.length;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int num : original) {
            graph.put(num, new HashSet<>());
            inDegree.put(num, 0);
        }

        for (List<Integer> seq : sequences) {
            for (int num : seq) {
                if (!inDegree.containsKey(num)) return false; // number out of the 1..n range
            }
            for (int i = 0; i + 1 < seq.size(); i++) {
                int from = seq.get(i), to = seq.get(i + 1);
                if (graph.get(from).add(to)) {          // Set prevents double-counting the same edge
                    inDegree.merge(to, 1, Integer::sum);
                }
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int num : inDegree.keySet()) {
            if (inDegree.get(num) == 0) queue.add(num);
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) return false; // uniqueness: there MUST be exactly one candidate per step
            int cur = queue.poll();
            if (idx >= n || cur != original[idx++]) return false;
            for (int next : graph.get(cur)) {
                inDegree.merge(next, -1, Integer::sum);
                if (inDegree.get(next) == 0) queue.add(next);
            }
        }
        return idx == n;
    }
}
