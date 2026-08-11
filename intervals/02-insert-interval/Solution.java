class Solution {
    public static List<List<Integer>> insertInterval(List<List<Integer>> intervals, List<Integer> newInterval) {
        List<List<Integer>> answer = new ArrayList<>();
        int i = 0;

        // Phase 1: BEFORE — no overlap
        for (; i < intervals.size() && intervals.get(i).get(1) < newInterval.get(0); i++) {
            answer.add(intervals.get(i));
        }

        // Phase 2: MERGE — all overlapping
        int startIdx = newInterval.get(0);
        int endIdx = newInterval.get(1);
        for (; i < intervals.size() && intervals.get(i).get(0) <= endIdx; i++) {
            startIdx = Math.min(intervals.get(i).get(0), startIdx);
            endIdx = Math.max(intervals.get(i).get(1), endIdx);
        }
        answer.add(List.of(startIdx, endIdx));

        // Phase 3: AFTER — no overlap
        for (; i < intervals.size(); i++) {
            answer.add(intervals.get(i));
        }

        return answer;
    }
}
