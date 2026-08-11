class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];       // dp[i] = length of the largest divisible subset ENDING at nums[i]
        int[] prev = new int[n];     // prev[i] = index of the previous element in that subsequence (-1 if nums[i] starts it)
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int bestIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[bestIndex]) bestIndex = i;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = bestIndex; i != -1; i = prev[i]) {
            result.add(nums[i]);
        }
        Collections.reverse(result);
        return result;
    }
}
