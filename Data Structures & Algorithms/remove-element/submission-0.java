class Solution {
    public int removeElement(int[] nums, int val) {
        int i = -1;
        int k = 0;
        for(int j = 0; j < nums.length; j++)
        {
            if(nums[j] != val)
            {
                k++;
                nums[++i] = nums[j];
            }
        }
        return k;
    }
}