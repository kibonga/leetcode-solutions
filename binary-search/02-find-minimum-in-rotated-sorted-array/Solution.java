class Solution {
    public static int findMinRotated(List<Integer> arr) {
        int low = 0, high = arr.size() - 1;
        int leftmostIdx = -1;
        while (low <= high) {                          // <=, not <
            int mid = low + (high - low) / 2;
            if (arr.get(mid) > arr.get(high)) {
                low = mid + 1;
            } else {
                leftmostIdx = mid;                     // EXPLICITLY remember this candidate
                high = mid - 1;                        // EXCLUDE mid (but it's already been remembered)
            }
        }
        return arr.get(leftmostIdx);
    }
}
