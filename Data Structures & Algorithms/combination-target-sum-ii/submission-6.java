class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    void recurse(int[] nums, int start, int target, List<Integer> list) {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {

            // Skip duplicates at the same recursion level
            if (i > start && nums[i] == nums[i - 1])
                continue;

            // Since nums is sorted, no later number can work
            if (nums[i] > target)
                break;

            list.add(nums[i]);

            // i + 1 because each number can be used only once
            recurse(nums, i + 1, target - nums[i], list);

            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        recurse(nums, 0, target, new ArrayList<>());
        return ans;
    }
}
