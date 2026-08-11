class Solution {
    public static List<List<Integer>> combinationSum(List<Integer> candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Collections.sort(candidates);   // enables pruning
        dfs(answer, candidates, current, 0, target, 0);
        return answer;
    }

    private static void dfs(List<List<Integer>> answer, List<Integer> candidates, List<Integer> current,
                             int currentSum, int target, int start) {
        if (currentSum > target) return;
        if (currentSum == target) {
            answer.add(new ArrayList<>(current));   // COPY, not a reference!
            return;
        }
        for (int i = start; i < candidates.size(); i++) {
            var candidate = candidates.get(i);
            current.add(candidate);
            currentSum += candidate;

            dfs(answer, candidates, current, currentSum, target, i);   // passes i, NOT i+1

            currentSum -= candidate;
            current.remove(current.size() - 1);
        }
    }
}
