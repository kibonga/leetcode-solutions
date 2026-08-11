class Solution {
    public static int mySqrt(int x) {
        long low = 0, high = x;
        long answer = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid <= x) {
                answer = mid;      // candidate, but a LARGER one that still satisfies the condition might exist
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) answer;
    }
}
