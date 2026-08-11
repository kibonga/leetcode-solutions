class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();  // default min-heap

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();  // evict the smallest of the k+1 candidates seen so far
            }
        }

        return minHeap.peek();  // top = smallest of the k largest = k-th largest
    }
}
