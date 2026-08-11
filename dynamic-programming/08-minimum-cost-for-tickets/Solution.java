class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> travelDays = new HashSet<>();
        for (int d : days) travelDays.add(d);
        int lastDay = days[days.length - 1];

        int[] dp = new int[lastDay + 1];
        for (int day = 1; day <= lastDay; day++) {
            if (!travelDays.contains(day)) {
                dp[day] = dp[day - 1];   // don't travel this day, no extra cost
                continue;
            }
            int oneDay = dp[day - 1] + costs[0];
            int sevenDay = dp[Math.max(0, day - 7)] + costs[1];
            int thirtyDay = dp[Math.max(0, day - 30)] + costs[2];
            dp[day] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
        }
        return dp[lastDay];
    }
}
