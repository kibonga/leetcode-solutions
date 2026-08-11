class Solution {
    public static long minimizeMaxLoad(int[] times, int workers) {
        long low = 0, high = 0;
        for (int t : times) {
            low = Math.max(low, t);   // lower bound: at least the single heaviest newspaper
            high += t;                  // upper bound: one worker reads EVERYTHING
        }

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (canFinish(times, workers, mid)) {
                high = mid;              // mid is a feasible limit, try a smaller one
            } else {
                low = mid + 1;           // mid too small, need a bigger limit
            }
        }
        return low;
    }

    private static boolean canFinish(int[] times, int workers, long limit) {
        int used = 1;
        long currentLoad = 0;
        for (int t : times) {
            if (currentLoad + t > limit) {
                used++;
                currentLoad = 0;
                if (used > workers) return false;
            }
            currentLoad += t;
        }
        return true;
    }
}
