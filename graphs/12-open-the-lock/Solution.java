class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) return -1;
        if (target.equals("0000")) return 0;

        Queue<String> queue = new ArrayDeque<>();
        queue.add("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int turns = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String cur = queue.poll();
                for (String next : neighbors(cur)) {
                    if (dead.contains(next) || visited.contains(next)) continue;
                    if (next.equals(target)) return turns + 1;
                    visited.add(next);
                    queue.add(next);
                }
            }
            turns++;
        }
        return -1;
    }

    private List<String> neighbors(String state) {
        List<String> result = new ArrayList<>();
        char[] chars = state.toCharArray();
        for (int i = 0; i < 4; i++) {
            char original = chars[i];
            chars[i] = (char) ((original - '0' + 1) % 10 + '0');       // +1, cyclic
            result.add(new String(chars));
            chars[i] = (char) ((original - '0' + 9) % 10 + '0');       // -1, cyclic (+9 mod 10)
            result.add(new String(chars));
            chars[i] = original; // restore original before moving to the next position
        }
        return result;
    }
}
