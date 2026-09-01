class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Map<Integer, Integer> m = map.entrySet()
    .stream()
    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
    .collect(Collectors.toMap(
        Map.Entry::getKey,
        Map.Entry::getValue,
        (e1, e2) -> e1, 
        LinkedHashMap::new 
    ));
    int arr[] = new int[k];
    int j = 0;
    for(Map.Entry<Integer, Integer> entry : m.entrySet()) {
        if(j == k)
        break;
        
            arr[j++] = entry.getKey();
    }
    return arr;
    }
    
}
