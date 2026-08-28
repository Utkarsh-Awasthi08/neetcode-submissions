/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    List<Integer> list;
    public void post(Node root)
    {
        if(root == null)
        return;

        for(Node n : root.children)
        {
            post(n);
        }
        list.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        list = new ArrayList<>();
        post(root);
        return list;
    }
}