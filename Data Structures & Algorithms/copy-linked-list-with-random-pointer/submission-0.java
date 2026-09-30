class Solution {
    private class Real {
        Node a;
        int idx;

        public Real(Node b, int val) {
            this.a = b;
            this.idx = val;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        List<Real> list = new ArrayList<>();

        Node head1 = head;
        while (head1 != null) {
            list.add(new Real(head1, -1));
            head1 = head1.next;
        }

        // Store index of each random pointer
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).a.random == null) {
                list.get(i).idx = -1;
                continue;
            }

            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).a.random == list.get(j).a) {
                    list.get(i).idx = j;
                    break;
                }
            }
        }

        // Create copied nodes
        Node a = new Node(head.val);
        Node curr = a;
        head1 = head.next;

        while (head1 != null) {
            curr.next = new Node(head1.val);
            curr = curr.next;
            head1 = head1.next;
        }

        // Store copied nodes
        List<Real> list2 = new ArrayList<>();
        head1 = a;

        while (head1 != null) {
            list2.add(new Real(head1, -1));
            head1 = head1.next;
        }

        // Set random pointers
        for (int i = 0; i < list.size(); i++) {
            int idx = list.get(i).idx;

            if (idx != -1) {
                list2.get(i).a.random = list2.get(idx).a;
            }
        }

        return a;
    }
}
