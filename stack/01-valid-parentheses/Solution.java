class Solution {
    public static boolean validParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(' || curr == '[' || curr == '{') {
                stack.push(curr);
            } 
            else if (stack.isEmpty()) return false;
            else {
                char pop = stack.pop();
                if (curr == ')' && pop != '(') return false;
                if (curr == ']' && pop != '[') return false;
                if (curr == '}' && pop != '{') return false;
            }
        }
        return stack.isEmpty();
    }
}
