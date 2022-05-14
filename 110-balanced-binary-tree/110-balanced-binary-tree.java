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
    public boolean isBalanced(TreeNode root) {
        return help(root) != -1;
    }
    
    private int help(TreeNode root) {
        if(root == null) return 0;
        
        int left = help(root.left);
        int right = help(root.right);
        
        if(left == -1 || right == -1) {
            return -1;
        }
        
        if(Math.abs(left-right) > 1) return -1;
        
        return 1 + Math.max(help(root.left), help(root.right));
    }
        
}