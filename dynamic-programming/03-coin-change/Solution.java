class Solution {
    public static int coinChange(List<Integer> coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        int result = dfs(coins, memo, amount, amount);
        return result >= amount + 1 ? -1 : result;
    }
    private static int dfs(List<Integer> coins, int[] memo, int amount, int remaining) {
        if (remaining == 0) return 0;
        if (remaining < 0) return amount + 1;
        if (memo[remaining] != -1) return memo[remaining];
        int minCoins = Integer.MAX_VALUE;
        for (var coin : coins) {
            minCoins = Math.min(minCoins, dfs(coins, memo, amount, remaining - coin) + 1);
        }
        return memo[remaining] = minCoins;
    }
}
