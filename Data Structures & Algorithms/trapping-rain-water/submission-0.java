class Solution {
    public int trap(int[] height) {
        int curr = height[0];
        int s = 0;
        for(int i = 1; i < height.length - 1; i++)
        {
           int l = height[i];
           for(int j = i - 1; j >= 0; j--)
           {
                if(height[j] > l)
                l = height[j];
           }
           int r = height[i];
           for(int j = i + 1; j < height.length; j++)
           {
                if(height[j] > r)
                r = height[j];
           }
           s+= Math.min(l, r) - height[i];
        }
        return s;
    }
}
