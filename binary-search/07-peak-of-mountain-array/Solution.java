class Solution {
    public static int peakIndexInMountainArray(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;     // still rising, the peak is STRICTLY to the right of mid
            } else {
                high = mid;        // arr[mid] > arr[mid+1], mid COULD be the peak, keep it
            }
        }
        return low;
    }
}
