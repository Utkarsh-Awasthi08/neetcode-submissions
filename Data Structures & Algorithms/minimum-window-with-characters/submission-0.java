class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map for characters in t
        int[] targetCount = new int[128];
        for (int i = 0; i < t.length(); i++) {
            targetCount[t.charAt(i)]++;
        }

        int left = 0;
        int right = 0;
        int required = t.length(); // Total characters needed from t
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        while (right < s.length()) {
            char rChar = s.charAt(right);
            
            // If this character is needed, decrement required count
            if (targetCount[rChar] > 0) {
                required--;
            }
            // Decrement frequency in map (can become negative for surplus chars)
            targetCount[rChar]--;
            right++;

            // When the current window satisfies all characters of t
            while (required == 0) {
                // Update shortest substring window
                if (right - left < minLen) {
                    minLen = right - left;
                    startIndex = left;
                }

                // Try shrinking the window from the left
                char lChar = s.charAt(left);
                targetCount[lChar]++;
                
                // If removing this char breaks the requirement, increment required
                if (targetCount[lChar] > 0) {
                    required++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}