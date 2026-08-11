class Solution {
    // dp[i] = longest increasing subsequence STARTING at nums[i], loop runs backward
    for (int i = n; i >= 0; i--) {
        for (int j = i; j < n; j++) {
            if (nums[i] < nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
        }
    }
    return dp[0];   // BUG — the LIS doesn't have to start at nums[0]!
}
