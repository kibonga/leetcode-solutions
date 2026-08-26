class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for (int stone : stones) totalSum += stone;
        int target = totalSum / 2;   // floor, intentional — see Common Pitfalls #3

        boolean[][] dp = new boolean[stones.length + 1][target + 1];
        dp[0][0] = true;

        for (int i = 1; i <= stones.length; i++) {
            int num = stones[i - 1];
            for (int j = 0; j <= target; j++) {
                boolean skip = dp[i - 1][j];
                boolean take = (j >= num) && dp[i - 1][j - num];
                dp[i][j] = skip || take;
            }
        }

        int bestSum = 0;
        for (int j = target; j >= 0; j--) {   // backward, break on the FIRST (=largest) true
            if (dp[stones.length][j]) {
                bestSum = j;
                break;
            }
        }

        return totalSum - 2 * bestSum;
    }
}
