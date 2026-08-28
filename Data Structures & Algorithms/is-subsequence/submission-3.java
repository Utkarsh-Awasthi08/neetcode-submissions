class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0)
        return true;
        
        if(t.length() < s.length())
        return false;

        int j = -1;
        for(int i = 0; i < t.length(); i++)
        {
            if(s.charAt(0) == t.charAt(i))
            {
                j = i;
                break;
            }
        }
        if(j == -1)
        return false;

        else if(s.length() == 1)
        return true;

        for(int i = 1; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            boolean flag = false;
            for(int k = j + 1; k < t.length(); k++)
            {
                if(ch == t.charAt(k))
                {
                    flag = true;
                    j = k;
                    break;
                }
            }
            if(!flag)
            return false;
        }
        return true;
    }
}