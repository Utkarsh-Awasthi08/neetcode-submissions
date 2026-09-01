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

// Here we traverse the array from both the ends and check which one is smaller. Then calculte the area according to smaller tower from i to j index. Assign that area to max by comparing against current value. Then we check if tower of i is smaller that tower at j then we increment the i index as if we j-- then also the area cannot be greater than the current one. Same thing to do if tower at j is smaller that tower at i. If both have equal height then move both as if we move only one then greater area is not possible. 
