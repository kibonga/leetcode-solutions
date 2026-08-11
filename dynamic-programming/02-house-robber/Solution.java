class Solution {
    private static int dfs(List<Integer> nums, int[] memo, int start, int currentSum) {
        if (start >= nums.size()) return currentSum;
        if (memo[start] != -1) return memo[start];
        int current = nums.get(start);
        int maxSum = Math.max(
            dfs(nums, memo, start + 2, currentSum + current),
            dfs(nums, memo, start + 1, currentSum)
        );
        return memo[start] = maxSum;
    }
}
