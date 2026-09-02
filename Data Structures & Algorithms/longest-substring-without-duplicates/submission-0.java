class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
        return 0;
        if(s.length() == 1)
        return 1;

        int w = 1;
        StringBuilder sb = new StringBuilder(s.substring(0,1));
        for(int i = 1; i < s.length(); i++){
            char a = s.charAt(i);
            if(sb.indexOf(String.valueOf(a)) == -1){
                sb.append(a);
                w = Math.max(w, sb.length());
                continue;
            }
            sb.delete(0, sb.indexOf(String.valueOf(a)) + 1);
            sb.append(a);
        }
        return w;
    }
}
