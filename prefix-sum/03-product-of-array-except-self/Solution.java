class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];   // result[i] = product of EVERYTHING to the left of i
        }

        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffixProduct;                // multiply by the product of EVERYTHING to the right of i
            suffixProduct *= nums[i];
        }

        return result;
    }
}
