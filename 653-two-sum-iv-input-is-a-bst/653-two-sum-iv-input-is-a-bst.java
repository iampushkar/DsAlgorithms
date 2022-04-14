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
    public boolean findTarget(TreeNode root, int k) {
        return t2Sum(root, k);
    }
    
    public boolean t2Sum(TreeNode A, int B) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(A, list);

        int start = 0, end = list.size()-1;
        while(start < end) {
            int sum = list.get(start) + list.get(end);

            if(sum < B) {
                start++;
            } else if(sum > B) {
                end--;
            } else {
                return true;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, ArrayList<Integer> list) {
        if(root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}