class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
        return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        boolean f = true;
            for(Map.Entry<Character, Integer> k : map1.entrySet()){
                char a = k.getKey();
                if(!map2.containsKey(a) || !(map2.get(a) == map1.get(a)))
                {
                    f = false;
                    break;
                }
            }
            if(f)
            return true;
        
        int j = s1.length();
        for(int i = 1; j < s2.length(); i++){
            map2.put(s2.charAt(i - 1), map2.get(s2.charAt(i - 1)) - 1);
            map2.put(s2.charAt(j), map2.getOrDefault(s2.charAt(j), 0) + 1);
            boolean flag = true;
            for(Map.Entry<Character, Integer> k : map1.entrySet()){
                char a = k.getKey();
                if(!map2.containsKey(a) || !(map2.get(a) == map1.get(a)))
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
            return true;

            j++;
        }
        return false;
    }
}
