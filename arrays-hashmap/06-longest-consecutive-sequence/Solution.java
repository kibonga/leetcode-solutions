class Solution {
    public static int longestConsecutiveSequence(List<Integer> nums) {
        Set<Integer> numSet = new HashSet<>(nums);
        int longest = 0;

        for (int num : numSet) {  // WARNING: KEY POINT: iterate over the SET, not the original list
            if (!numSet.contains(num - 1)) {
                int current = 1;
                while (numSet.contains(num + current)) {
                    current++;
                }
                longest = Math.max(longest, current);
            }
        }
        return longest;
    }
}
