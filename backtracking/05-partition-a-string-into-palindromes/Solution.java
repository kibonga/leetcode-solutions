class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] isPalindrome = buildPalindromeTable(s);
        dfs(s, 0, new ArrayList<>(), result, isPalindrome);
        return result;
    }

    private void dfs(String s, int start, List<String> current,
                      List<List<String>> result, boolean[][] isPalindrome) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (!isPalindrome[start][end]) continue;   // pruning - O(1) check
            current.add(s.substring(start, end + 1));
            dfs(s, end + 1, current, result, isPalindrome);
            current.remove(current.size() - 1);
        }
    }

    private boolean[][] buildPalindromeTable(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) &&
                    (end - start <= 2 || isPal[start + 1][end - 1])) {
                    isPal[start][end] = true;
                }
            }
        }
        return isPal;
    }
}
