class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1)
        return stones[0];

        if(stones.length == 2)
        return Math.abs(stones[0] - stones[1]);

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones)
        q.offer(i);

        while(q.size() > 1){
            int x = q.poll();
            int y = q.poll();

            if(x == y)
            continue;

            q.offer(x - y);
        }
        return q.isEmpty() ? 0 : q.peek();
    }
}
