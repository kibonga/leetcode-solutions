class Solution {
    public int numDecodings(String s) {
        Integer[] memo = new Integer[s.length()];
        return dfs(s, 0, memo);
    }

    private int dfs(String s, int index, Integer[] memo) {
        if (index == s.length()) return 1;          // empty remainder = 1 way (decode nothing further)
        if (s.charAt(index) == '0') return 0;        // decoding CANNOT start with a zero
        if (memo[index] != null) return memo[index];

        int ways = dfs(s, index + 1, memo);          // branch A: decode ONE digit

        if (index + 1 < s.length()) {                // branch B: decode TWO digits (if valid)
            int twoDigit = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                ways += dfs(s, index + 2, memo);
            }
        }

        return memo[index] = ways;
    }
}
