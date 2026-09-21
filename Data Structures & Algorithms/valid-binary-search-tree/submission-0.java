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
    boolean hello(TreeNode root, int low, int high){
        if(root == null)
        return true;

        if(root.val <= low || root.val >= high)
        return false;

        return hello(root.left, low, root.val) && hello(root.right, root.val, high);
    }
    public boolean isValidBST(TreeNode root) {
        
        return hello(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
