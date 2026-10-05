class Solution {
    List<List<Integer>> list2;
    void recurse(int nums[], int i, List<Integer> list){
        for(int j = i; j < nums.length; j++){
            list.add(nums[j]);
            if(list2.contains(list))
            continue;

            list2.add(new ArrayList<>(list));
            recurse(nums, j + 1, list);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        list2 = new ArrayList<>();
        list2.add(new ArrayList<>());
        recurse(nums, 0, new ArrayList<>());
        return list2;
    }
}
