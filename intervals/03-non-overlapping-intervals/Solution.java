class Solution {
    public static int nonOverlappingIntervals(List<List<Integer>> intervals) {
        intervals.sort(Comparator.<List<Integer>>comparingInt(a -> a.get(1)).thenComparing(a -> a.get(0)));
        int endi = Integer.MIN_VALUE;
        int removedCount = 0;
        for (var interval : intervals) {
            if (interval.get(0) >= endi) {
                endi = interval.get(1);
            } else {
                removedCount++;
            }
        }
        return removedCount;
    }
}
