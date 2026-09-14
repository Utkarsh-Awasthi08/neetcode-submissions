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
    void recurse(TreeNode root){
        if(root == null)
        return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        recurse(root.left);
        recurse(root.right);
    }
    public TreeNode invertTree(TreeNode root) {
        recurse(root);
        return root;
    }
}
