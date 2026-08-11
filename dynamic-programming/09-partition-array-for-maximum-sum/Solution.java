class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];   // dp[i] = max sum for arr[0..i)

        for (int i = 1; i <= n; i++) {
            int blockMax = 0;
            for (int len = 1; len <= k && len <= i; len++) {
                blockMax = Math.max(blockMax, arr[i - len]);   // extend block backward, tracking max along the way
                dp[i] = Math.max(dp[i], dp[i - len] + blockMax * len);
            }
        }
        return dp[n];
    }
}
