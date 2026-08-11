class Solution {
    public static List<List<String>> groupAnagrams(List<String> strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (var word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            map.computeIfAbsent(sortedWord, key -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
