class Solution {
    public boolean divisorGame(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;   // player to move with n=0 has no valid move -> loses
        dp[1] = false;   // n=1 has no divisor 0<x<1 -> loses

        for (int state = 2; state <= n; state++) {
            for (int x = 1; x < state; x++) {
                if (state % x == 0 && !dp[state - x]) {   // there's a move that leaves the OPPONENT in a losing state
                    dp[state] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
