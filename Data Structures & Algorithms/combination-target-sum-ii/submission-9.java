class Solution {
    HashSet<List<Integer>> list2;

    void recurse(int[] nums, int i, int s, int t, List<Integer> list) {

        for (int j = i; j < nums.length; j++) {

            if (s + nums[j] > t)
                break;

            if (j > i && nums[j] == nums[j - 1])
                continue;

            if (s + nums[j] == t) {
                list.add(nums[j]);
                list2.add(new ArrayList<>(list));
                list.remove(Integer.valueOf(nums[j]));
            }
            else {
                list.add(nums[j]);

                recurse(nums, j + 1, s + nums[j], t, list);

                list.remove(Integer.valueOf(nums[j]));
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {

        Arrays.sort(nums);

        list2 = new HashSet<>();

        recurse(nums, 0, 0, target, new ArrayList<>());

        return new ArrayList<>(list2);
    }
}
