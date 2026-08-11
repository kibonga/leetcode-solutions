class Solution {
    public static int searchInRotatedSortedArray(List<Integer> nums, int target) {
        int n = nums.size(), left = 0, right = n - 1;
        while (left <= right) {
            int midIdx = left + (right - left) / 2;
            int mid = nums.get(midIdx);
            if (mid == target) return midIdx;
            else if (mid <= nums.get(right)) {
                // right half is sorted
                if (mid < target && target <= nums.get(right)) left = midIdx + 1;
                else right = midIdx - 1;
            } else {
                // left half is sorted
                if (nums.get(left) <= target && target < mid) right = midIdx - 1;
                else left = midIdx + 1;
            }
        }
        return -1;
    }
}
