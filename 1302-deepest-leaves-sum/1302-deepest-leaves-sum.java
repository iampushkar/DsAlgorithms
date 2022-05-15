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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        queue.add(root);
        queue.add(null);
        
        while(queue.size() > 1) {
            TreeNode node = queue.poll();
            list.add(node);
            if(node == null) {
                queue.add(null);
            } else {
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        
        int sum = 0;
        for(int i=list.size()-1; i>=0; i--) {
            if(list.get(i) != null) {
                //System.out.println(node.val + "-> " + sum);
                sum += list.get(i).val;
            } else {
                break;
            }
        }
        return sum;
    }
}

/*
1 n 2 3 n 4 5 6 n 7 8 n 
x x x x x x x x x 

*/