class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void dfs(int n, int open, int close, StringBuilder current, List<String> result) {
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }
        if (open < n) {
            current.append('(');
            dfs(n, open + 1, close, current, result);
            current.deleteCharAt(current.length() - 1);
        }
        if (close < open) {
            current.append(')');
            dfs(n, open, close + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
