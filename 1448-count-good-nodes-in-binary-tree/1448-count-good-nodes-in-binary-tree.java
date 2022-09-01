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
    int count = 1;
    public int goodNodes(TreeNode root) {
        helper(root.left, root.val);
        helper(root.right, root.val);
        
        return count;
    }
    
    private void helper(TreeNode root, int maxVal) {
        
        if(root == null) return;
        
        if(root.val >= maxVal) {
            count++;
            maxVal = root.val;
        }
        helper(root.left, maxVal);
        helper(root.right, maxVal);
        
    }
}