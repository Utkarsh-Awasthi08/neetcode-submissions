class Solution {
    public int[] twoSum(int[] numbers, int target) {
        List<Integer> list = new ArrayList<>();
        int i = 0; 
        int j = numbers.length - 1;
        while(i < j)
        {
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                list.add(i + 1);
                list.add(j + 1);
                return list.stream().mapToInt(Integer::intValue).toArray();
            }
            else if(sum < target)
            i++;

            else
            j--;
        }
        return numbers;
    }
}
