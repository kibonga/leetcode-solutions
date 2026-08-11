class Solution {
    private static final Map<Character, String> DIGIT_LETTERS = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        dfs(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void dfs(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String letters = DIGIT_LETTERS.get(digits.charAt(index));
        for (char c : letters.toCharArray()) {
            current.append(c);
            dfs(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);   // backtrack
        }
    }
}
