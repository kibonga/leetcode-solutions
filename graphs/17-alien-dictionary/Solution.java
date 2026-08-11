class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String w : words) {
            for (char c : w.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i + 1 < words.length; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            boolean foundDiff = false;

            for (int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (graph.get(c1).add(c2)) {           // Set prevents double-counting the same edge
                        inDegree.merge(c2, 1, Integer::sum);
                    }
                    foundDiff = true;
                    break; // ONLY the first difference carries information, the rest is ignored
                }
            }
            if (!foundDiff && w1.length() > w2.length()) return ""; // "abc" before "ab" — invalid by definition
        }

        Queue<Character> queue = new ArrayDeque<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) queue.add(c);
        }

        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            order.append(cur);
            for (char next : graph.get(cur)) {
                if (inDegree.merge(next, -1, Integer::sum) == 0) queue.add(next);
            }
        }
        return order.length() == inDegree.size() ? order.toString() : ""; // < total letters -> cycle
    }
}
