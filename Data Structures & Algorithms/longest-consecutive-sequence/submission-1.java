class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for (int num : nums) {
            numbers.add(num);
        }

        int longest = 0;

        for (int num : numbers) {
            // Only start counting at the beginning of a sequence
            if (!numbers.contains(num - 1)) {
                int length = 1;
                int current = num;

                while (numbers.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}