class Solution {
    public List<String> taskScheduling(List<String> tasks, List<List<String>> requirements) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        for (String task : tasks) inDegree.put(task, 0);

        for (List<String> req : requirements) {
            String before = req.get(0), after = req.get(1);
            graph.computeIfAbsent(before, k -> new ArrayList<>()).add(after);
            inDegree.merge(after, 1, Integer::sum);
        }

        Queue<String> queue = new ArrayDeque<>();
        for (String task : tasks) {
            if (inDegree.get(task) == 0) queue.add(task);
        }

        List<String> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            order.add(cur);
            for (String next : graph.getOrDefault(cur, List.of())) {
                inDegree.merge(next, -1, Integer::sum);
                if (inDegree.get(next) == 0) queue.add(next);
            }
        }
        return order.size() == tasks.size() ? order : List.of(); // empty list = cycle, impossible
    }
}
