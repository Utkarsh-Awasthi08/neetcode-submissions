class Solution {
    int n = 0;

    void recurse(TreeNode root, int max) {
        if (root == null) {
            return;
        }

        if (root.val >= max) {
            n++;
            max = root.val;
        }

        recurse(root.left, max);
        recurse(root.right, max);
    }

    public int goodNodes(TreeNode root) {
        recurse(root, Integer.MIN_VALUE);
        return n;
    }
}
