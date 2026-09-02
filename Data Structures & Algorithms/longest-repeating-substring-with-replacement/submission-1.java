class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() == 1)
        return 1;
        int len = 1;
        int maxF = 1;
        int i = 0;
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(i), 1);
        for(int j = 1; j < s.length(); j++){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            maxF = Math.max(maxF, map.get(s.charAt(j)));
            len = j - i + 1;

            if((len - maxF) > k){
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
                len = j - i + 1;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }
}
