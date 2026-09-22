class MinStack {
    // Custom Node class to store the value, the minimum so far, and the next node
    private class Node {
        int val;
        int min;
        Node next;
        
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    
    // The head of our linked-list stack
    private Node head;

    public MinStack() {
        // Stack is initially empty
        head = null;
    }
    
    public void push(int val) {
        if (head == null) {
            // First element is both the value and the minimum
            head = new Node(val, val, null);
        } else {
            // Link the new node to the current head and calculate the new minimum
            head = new Node(val, Math.min(val, head.min), head);
        }
    }
    
    public void pop() {
        if (head != null) {
            // Move the head pointer back to the previous node
            head = head.next;
        }
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}