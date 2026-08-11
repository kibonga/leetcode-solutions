class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> dp = new HashMap<>();
        int best = 1;

        for (String word : words) {
            int longest = 1;   // the word itself, chain of length 1
            for (int i = 0; i < word.length(); i++) {
                String predecessor = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(predecessor)) {
                    longest = Math.max(longest, dp.get(predecessor) + 1);
                }
            }
            dp.put(word, longest);
            best = Math.max(best, longest);
        }
        return best;
    }
}
