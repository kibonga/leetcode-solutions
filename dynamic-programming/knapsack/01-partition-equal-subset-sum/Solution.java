class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int cap = target; cap >= num; cap--) {   // BACKWARD: each number used at most once (0/1)
                dp[cap] = dp[cap] || dp[cap - num];
            }
        }
        return dp[target];
    }
}
