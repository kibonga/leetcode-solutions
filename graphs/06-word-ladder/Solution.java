class Solution {
    public static int wordLadder(String begin, String end, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(end) || !wordSet.contains(begin)) return -1;

        Queue<String> queue = new ArrayDeque<>();
        queue.add(begin);
        Set<String> visited = new HashSet<>();
        visited.add(begin);
        int level = 1;  // beginWord is the first word in the sequence

        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // captured BEFORE the loop, not a live queue.size()

            for (int l = 0; l < levelSize; l++) {
                var currentWord = queue.poll();
                if (currentWord.equals(end)) return level;  // .equals(), NOT ==

                for (int i = 0; i < currentWord.length(); i++) {  // currentWord.length(), NOT end.length()
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        String newWord = currentWord.substring(0, i) + ch + currentWord.substring(i + 1);
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            queue.add(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
