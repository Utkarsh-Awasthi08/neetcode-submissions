class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(int i : nums)
        map.put(i, map.getOrDefault(i , 0) + 1);

        map.forEach((key, value) -> {
            q.add(key);
        });

        int arr[] = new int[k];
        int i = 0;
        while(i < k)
        {
            arr[i] = q.poll();
            i++;
        }
        

        return arr;
    }
}
