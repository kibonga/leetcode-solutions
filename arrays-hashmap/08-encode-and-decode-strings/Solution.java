class Solution {
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (var word : strs) {
            sb.append(word.length()).append("#").append(word);
        }
        return sb.toString();
    }
}
