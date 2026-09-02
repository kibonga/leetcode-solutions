class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long currDay = 0;
        Map<Integer, Long> earliestAllowedDay = new HashMap<>();

        for (var task : tasks) {
            long candidateDay = currDay + 1;
            long actualDay = earliestAllowedDay.containsKey(task) ?
                                Math.max(candidateDay, earliestAllowedDay.get(task)) :
                                candidateDay;

            currDay = actualDay;
            earliestAllowedDay.put(task, currDay + space + 1);
        }

        return currDay;
    }
}
