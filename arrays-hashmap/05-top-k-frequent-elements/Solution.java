class Solution {
    public static List<Integer> topKFrequentElements(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.merge(num, 1, Integer::sum);
        }

        Comparator<Map.Entry<Integer, Integer>> comparator = Comparator
            .comparingInt((Map.Entry<Integer, Integer> e) -> e.getValue())
            .thenComparing(e -> -e.getKey());

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(comparator);

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.stream()
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }
}
