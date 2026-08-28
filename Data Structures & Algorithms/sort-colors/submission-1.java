class Solution {
    int j = 0;
    public void sortColors(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i : nums)
        {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
      
        map.forEach((key, value) -> {
            int a = value;
            while(a-- > 0)
            {
                nums[j] = key;
                j++;
            }
        });
    }
}