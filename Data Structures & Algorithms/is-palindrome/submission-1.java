class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.trim().replaceAll("\\s+","");
        StringBuilder sb = new StringBuilder(s);
        for(int i = sb.length() - 1; i >= 0; i--){
            int a = (int)sb.charAt(i);
            if(!(a >= 48 && a <= 57) && !(a >= 97 && a <= 122))
            sb.deleteCharAt(i);
        }
        System.out.println(sb.toString());
        int j = sb.length() - 1;
        for(int i = 0; i < j; i++){
            if(sb.charAt(i) != sb.charAt(j - i))
            return false;
        }
        return true;
    }
}
