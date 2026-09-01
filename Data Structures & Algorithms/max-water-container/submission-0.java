class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int max = Integer.MIN_VALUE;
        

        while(i < j){
            if(heights[i] < heights[j]){
                int a = heights[i] * (j - i);
                max = Math.max(max, a);
                i++;
            }
            else if(heights[i] > heights[j]){
                int a = heights[j] * (j - i);
                max = Math.max(max, a);
                j--;
            }
            else{
                int a = heights[i] * (j - i);
                max = Math.max(max, a);
                i++;
                j--;
            }
        }
        return max;
    }
}
