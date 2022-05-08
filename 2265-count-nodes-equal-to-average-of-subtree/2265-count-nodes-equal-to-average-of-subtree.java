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
    int ans = 0;
    public int averageOfSubtree(TreeNode root) {
        avg(root);
        return ans;
    }
    
    private int[] avg(TreeNode root) {
        if(root == null) {
            return new int[] {0, 0};
        }
        
        int[] left = avg(root.left);
        int[] right = avg(root.right);
        
        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;
        
        if(sum/count == root.val) {
            ans++;
        }
        
        return new int[]{sum, count};
    }
}