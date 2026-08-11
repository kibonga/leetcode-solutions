class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, current, result);
        return result;
    }

    private void dfs(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            current.add(nums[i]);
            dfs(nums, used, current, result);
            current.remove(current.size() - 1);
            used[i] = false;   // MANDATORY undo - used is shared and ACTIVELY read
        }
    }
}
