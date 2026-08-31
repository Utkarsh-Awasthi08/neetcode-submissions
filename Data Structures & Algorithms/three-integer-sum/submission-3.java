class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> list = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == 0){
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);

                    list.add(l);
                    j++;
                    k--;
                }
                else if(sum < 0){
                    j++;
                }
                else
                k--;
            }
        }
        return list.stream().collect(Collectors.toList());
    }
}
