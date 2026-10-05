class Solution {
    List<List<Integer>> list2;
    void recurse(int nums[], int target, int s, List<Integer> list, int i){

        for(int j = i; j < nums.length; j++){
            if(nums[j] == 0)
            continue;

            if(s + nums[j] < target){
                list.add(nums[j]);
                recurse(nums, target, s + nums[j], list, j);
                list.remove(Integer.valueOf(nums[j]));
            }
            
            else if((s + nums[j]) == target)
            {
                list.add(nums[j]);
                if(list2.contains(list)){
                    list.remove(Integer.valueOf(nums[j]));
                    continue;
                }
                
                list2.add(new ArrayList<>(list));
                list.remove(Integer.valueOf(nums[j]));
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        list2 = new ArrayList<>();
        recurse(nums, target, 0, new ArrayList<>(), 0);
        return list2;
    }
}
