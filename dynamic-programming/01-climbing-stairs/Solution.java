class Solution {
    public static long climbingStairs(int n) {
        return dfs(n, 0);
    }
    private static long dfs(long totalSteps, long currentSteps) {
        if (currentSteps == totalSteps) return 1;
        if (currentSteps > totalSteps) return 0;
        return dfs(totalSteps, currentSteps+1) + dfs(totalSteps, currentSteps+2);
    }
}
