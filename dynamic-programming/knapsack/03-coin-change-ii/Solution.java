class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;   // one way to reach 0: take no coins

        for (int coin : coins) {                       // OUTER loop: coin type (guarantees combinations, not permutations)
            for (int cap = coin; cap <= amount; cap++) {   // INNER loop FORWARD: unbounded (coin can repeat)
                dp[cap] += dp[cap - coin];
            }
        }
        return dp[amount];
    }
}
