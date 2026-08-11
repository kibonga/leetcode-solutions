class Solution {
    public static List<List<Integer>> mergeIntervals(List<List<Integer>> intervals) {
        intervals.sort(
            Comparator.<List<Integer>>comparingInt(x -> x.get(0))
                .thenComparing(x -> x.get(1))
        );
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(intervals.get(0));
        for (var interval : intervals) {
            var lastAnswer = answer.get(answer.size()-1);
            if (interval.get(0) > lastAnswer.get(1)) {
                answer.add(interval);
            } else {
                lastAnswer.set(1, Math.max(lastAnswer.get(1), interval.get(1)));
            }
        }
        return answer;
    }
}
