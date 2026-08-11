class Solution {
    public static boolean containsDuplicate(List<Integer> nums) {
        return new HashSet<>(nums).size() != nums.size();
    }
}
