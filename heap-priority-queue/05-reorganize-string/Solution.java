class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        int maxFreq = 0;
        for (int f : freq) maxFreq = Math.max(maxFreq, f);
        if (maxFreq > (n + 1) / 2) return "";  // pigeonhole: physically impossible to arrange

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);  // {charIndex, count}, max by count
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) maxHeap.offer(new int[]{i, freq[i]});
        }

        StringBuilder result = new StringBuilder();
        int[] prev = null;

        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            result.append((char) ('a' + current[0]));
            current[1]--;

            if (prev != null && prev[1] > 0) {
                maxHeap.offer(prev);  // return the PREVIOUS character to the heap only NOW (cooldown of exactly 1 position)
            }
            prev = current;
        }

        return result.toString();
    }
}
