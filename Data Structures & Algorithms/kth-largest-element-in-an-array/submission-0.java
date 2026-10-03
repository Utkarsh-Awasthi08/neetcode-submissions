class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : nums){
            q.offer(i);
        }
        int a = -1;
        while(k > 0){
            a = q.poll();
            k--;
        }
        return a;
    }
}
