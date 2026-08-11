class Solution {
    public int taskScheduling2(List<String> tasks, Map<String, Integer> times, List<List<String>> requirements) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        for (String task : tasks) inDegree.put(task, 0);

        for (List<String> req : requirements) {
            String before = req.get(0), after = req.get(1);
            graph.computeIfAbsent(before, k -> new ArrayList<>()).add(after);
            inDegree.merge(after, 1, Integer::sum);
        }

        Map<String, Integer> finishTime = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        for (String task : tasks) {
            if (inDegree.get(task) == 0) {
                queue.add(task);
                finishTime.put(task, times.get(task)); // no prerequisites -> starts immediately at time 0
            }
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            answer = Math.max(answer, finishTime.get(cur));
            for (String next : graph.getOrDefault(cur, List.of())) {
                int candidateFinish = finishTime.get(cur) + times.get(next);
                finishTime.merge(next, candidateFinish, Math::max); // waits for the SLOWEST prerequisite
                if (inDegree.merge(next, -1, Integer::sum) == 0) queue.add(next);
            }
        }
        return answer;
    }
}
