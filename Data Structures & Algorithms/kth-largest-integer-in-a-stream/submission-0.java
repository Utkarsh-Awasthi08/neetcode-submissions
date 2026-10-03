class KthLargest {
    int k;
    PriorityQueue<Integer> q;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : nums){
            q.offer(i);
        }
    }
    
    public int add(int val) {
        Stack<Integer> st = new Stack<>();
        q.offer(val);
        int a = k;
        int b = -1;
        while(a > 0){
            b = q.poll();
            st.push(b);
            a--;
        }
        while(!st.isEmpty()){
            q.offer(st.pop());
        }
        System.out.println(b);
        return b;
    }
}
