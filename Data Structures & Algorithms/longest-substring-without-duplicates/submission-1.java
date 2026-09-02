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

// Here we first check for edge cases. Then we take window length w as 1 and initialize String Builder with the first character. then we keep sliding the window right while checking that the current sb does not have that character. If curent sb or window does not ave that character then we append sb with that char and check its length or rather window length against max window length w. If the character is present in sb or current window, then we delete the characters from the stat of sb till the occurence of that character in the sb. Then we start the window from the character just after the occurence of that character in earlier sb and append that char as well. 
