class Solution {
    public static boolean isValidCourseSchedule(int n, List<List<Integer>> prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        for (var prereq : prerequisites) {
            var course = prereq.get(0);
            var required = prereq.get(1);
            inDegree[course]++;
            adjList.get(required).add(course);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        int processedCount = 0;
        while (!queue.isEmpty()) {
            var node = queue.poll();
            processedCount++;
            for (var neighbor : adjList.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) queue.add(neighbor);
            }
        }
        return processedCount == n;
    }
}
