class Solution {
    public static int longestRepeatingCharacterReplacement(String s, int k) {
        int[] freqChar = new int[26];
        int maxLen = 0;
        int maxFreq = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            freqChar[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freqChar[s.charAt(right) - 'A']);
            while ((right - left + 1) - maxFreq > k) {
                freqChar[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
