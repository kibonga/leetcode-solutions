class Solution {
    private boolean dfs(String s, Set<String> words, Boolean[] memo, int start) {
        if (start > s.length()) return false;   // FIX #1 — used to be `> s.length() -> return true`
        if (start == s.length()) return true;   // explicit base case for EXACTLY reaching the end
        if (memo[start] != null) return memo[start];

        boolean found = false;
        for (int endIndex = start; endIndex < s.length(); endIndex++) {
            var word = s.substring(start, endIndex + 1);   // simplified from `s.substring(i-(i-start), i+1)`
            if (words.contains(word)) {
                found = dfs(s, words, memo, endIndex + 1);
                if (found) return memo[start] = true;
            }
        }
        return memo[start] = false;   // FIX #2 — memoizing the `false` branch was missing
    }
}
