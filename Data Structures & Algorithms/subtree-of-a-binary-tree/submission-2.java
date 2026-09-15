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
    boolean recurse(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null)
        return true;
        if(root == null && subRoot != null)
        return false;
        if(root != null && subRoot == null)
        return false;

        if(root.val != subRoot.val)
        return false;

        return recurse(root.left, subRoot.left) && recurse(root.right, subRoot.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot == null)
        return false;
        boolean flag = false;
        if(root.val == subRoot.val){
            flag = recurse(root, subRoot);
        }
        if(flag)
        return true;
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
