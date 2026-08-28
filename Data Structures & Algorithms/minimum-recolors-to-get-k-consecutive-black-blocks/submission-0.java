class Solution {
    public int minimumRecolors(String blocks, int k) {
        int s = Integer.MAX_VALUE;
        for(int i = 0; i < blocks.length() - k + 1; i++)
        {
            int c = 0;
            for(int j = 0; j < k; j++)
            {
                if(blocks.charAt(i + j) == 'W')
                c++;
            }
            s = Math.min(s, c);
        }
        return s;
    }
}