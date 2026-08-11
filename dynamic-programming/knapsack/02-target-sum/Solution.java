class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        if (Math.abs(target) > totalSum || (target + totalSum) % 2 != 0) return 0;

        int subsetSum = (target + totalSum) / 2;
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1;   // one way to reach sum 0: empty subset

        for (int num : nums) {
            for (int cap = subsetSum; cap >= num; cap--) {   // BACKWARD: 0/1 (each number used at most once)
                dp[cap] += dp[cap - num];
            }
        }
        return dp[subsetSum];
    }
}
