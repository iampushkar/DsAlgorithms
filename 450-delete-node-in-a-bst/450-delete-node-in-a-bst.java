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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        
        if(root.val == key) {
            //case 1 : leaf node 
            if(root.left == null && root.right == null) {
                return null;
            }
            
            //case 2 : one child node present
            if(root.left == null || root.right == null) {
                if(root.left == null) return root.right;
                else return root.left;
            }
            
            //case 3 : both child node present, min value in RST
            if(root.left != null && root.right != null) {
                int minVal = findMinValueInRst(root.right);
                root.val = minVal;
                root.right = deleteNode(root.right, minVal);
                return root;
            }
        }
        
        if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        
        return root;
    }
    
    private int findMinValueInRst(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}