class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        int[] factors = {2, 3, 5};

        minHeap.offer(1L);
        seen.add(1L);

        long ugly = 1L;
        for (int i = 0; i < n; i++) {
            ugly = minHeap.poll();
            for (int factor : factors) {
                long next = ugly * factor;
                if (seen.add(next)) {   // seen.add() returns false if already present -> combined contains+insert
                    minHeap.offer(next);
                }
            }
        }

        return (int) ugly;
    }
}
