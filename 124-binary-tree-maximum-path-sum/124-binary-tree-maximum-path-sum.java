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
    int ans = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        int x = sum(root);
        return ans;
    }
    
    private int sum(TreeNode root) {
        if(root == null) return 0;
        
        int left = Math.max(0, sum(root.left));
        int right = Math.max(0, sum(root.right));
        
        int sum = left + right + root.val;
        ans = Math.max(sum, ans);
        
        return root.val + Math.max(left, right);
    }
}