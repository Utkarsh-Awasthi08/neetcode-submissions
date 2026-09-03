class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        // Check first window
        if (map1.equals(map2)) {
            return true;
        }

        int j = s1.length();

        for (int i = 1; j < s2.length(); i++, j++) {

            // Remove left character
            char removed = s2.charAt(i - 1);
            map2.put(removed, map2.get(removed) - 1);

            if (map2.get(removed) == 0) {
                map2.remove(removed);
            }

            // Add right character
            char added = s2.charAt(j);
            map2.put(added, map2.getOrDefault(added, 0) + 1);

            if (map1.equals(map2)) {
                return true;
            }
        }

        return false;
    }
}
