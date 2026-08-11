class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] need = new int[26];
        for (char c : p.toCharArray()) need[c - 'a']++;

        int[] window = new int[26];
        int k = p.length();

        for (int right = 0; right < s.length(); right++) {
            window[s.charAt(right) - 'a']++;

            if (right >= k) {
                window[s.charAt(right - k) - 'a']--;
            }

            if (right >= k - 1 && Arrays.equals(window, need)) {
                result.add(right - k + 1);
            }
        }
        return result;
    }
}
