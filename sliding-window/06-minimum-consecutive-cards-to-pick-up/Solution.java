class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> lastSeenIndex = new HashMap<>();
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < cards.length; i++) {
            if (lastSeenIndex.containsKey(cards[i])) {
                minLen = Math.min(minLen, i - lastSeenIndex.get(cards[i]) + 1);
            }
            lastSeenIndex.put(cards[i], i);
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
