class Solution {
    public static List<List<Integer>> kClosestPoints(List<List<Integer>> points, int k) {
        // edge case: k >= points.size() -> heap holds everything, polling k times still works correctly

        Queue<List<Integer>> queue = new PriorityQueue<>(
            Comparator.comparingInt((List<Integer> pq) -> pq.get(0)*pq.get(0) + pq.get(1)*pq.get(1))
            // WITHOUT .reversed() -> min-heap, smallest distance on top
        );

        for (var point : points) {
            queue.add(point);
        }

        List<List<Integer>> closestKPoints = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            closestKPoints.add(queue.poll());
        }
        return closestKPoints;
    }
}
