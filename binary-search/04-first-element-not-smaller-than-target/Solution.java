class Solution {
    public static int firstNotSmaller(int[] arr, int target) {
        int low = 0, high = arr.length; // high = n (not n-1!) to cover "no such element"
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                high = mid;       // mid satisfies the condition, but a smaller index might ALSO satisfy it
            } else {
                low = mid + 1;    // mid doesn't satisfy it, the answer is STRICTLY to the right
            }
        }
        return low; // first index where arr[i] >= target, or arr.length if none exists
    }
}
