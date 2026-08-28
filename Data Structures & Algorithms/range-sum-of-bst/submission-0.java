/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int s;
    void sum(TreeNode root, int low, int high)
    {
        if(root == null)
        return;

        if(root.val <= high && root.val >= low)
        s+= root.val;
        sum(root.left, low, high);
        sum(root.right, low, high);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        s = 0;
        sum(root, low, high);
        return s;
    }
}