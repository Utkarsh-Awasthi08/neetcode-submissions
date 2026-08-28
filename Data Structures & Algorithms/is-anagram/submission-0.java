class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(char ch: s.toCharArray()){
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char ch: t.toCharArray()){
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        return map1.equals(map2);
    }
    public static boolean mapsEqual(Map<?, ?> map1, Map<?, ?> map2) {
    if (map1.size() != map2.size()) {
        return false;
    }
    for (Map.Entry<?, ?> entry : map1.entrySet()) {
        Object key = entry.getKey();
        if (!map2.containsKey(key)) {
            return false;
        }
        if (!Objects.equals(entry.getValue(), map2.get(key))) {
            return false;
        }
    }
    return true;
}
}
