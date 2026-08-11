class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));   // EVERY node is a valid subset, not just the leaves
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            dfs(nums, i + 1, current, result);   // i+1, NOT i - each element used AT MOST once
            current.remove(current.size() - 1);
        }
    }
}
