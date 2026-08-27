class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp = new int[nums.size() + 1][target + 1];
        Arrays.fill(dp[0], -1);
        dp[0][0] = 0;   // the only legitimate "0": empty subsequence, sum 0, length 0

        for (int i = 1; i <= nums.size(); i++) {
            int num = nums.get(i - 1);
            for (int j = 0; j <= target; j++) {
                int max = dp[i - 1][j];   // skip
                if (j >= num && dp[i - 1][j - num] != -1) {   // guard AND check that the source is NOT the sentinel
                    max = Math.max(max, dp[i - 1][j - num] + 1);   // take
                }
                dp[i][j] = max;
            }
        }

        return dp[nums.size()][target];   // already -1 if unreachable, no need for an extra ternary
    }
}
