class Solution {
    public static String getMinimumWindow(String original, String check) {
        int[] need = new int[128];
        int[] window = new int[128];
        int requiredChars = 0;
        int matchedChars = 0;
        for (var ch : check.toCharArray()) {
            need[ch]++;
            if (need[ch] == 1) requiredChars++;
        }
        int startIdx = 0;
        int minLen = Integer.MAX_VALUE;

        for (int left = 0, right = 0; right < original.length(); right++) {
            char currChar = original.charAt(right);
            window[currChar]++;
            if (need[currChar] > 0 && window[currChar] == need[currChar]) {
                matchedChars++;
            }
            while (matchedChars == requiredChars) {
                if (right - left + 1 < minLen) {  // or <=, or lexicographic, depending on the requirement
                    startIdx = left;
                    minLen = right - left + 1;
                }
                char tmpChar = original.charAt(left);
                if (need[tmpChar] > 0 && window[tmpChar] == need[tmpChar]) {
                    matchedChars--;
                }
                window[tmpChar]--;
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : original.substring(startIdx, startIdx + minLen);
    }
}
