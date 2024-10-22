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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> bfsQ = new LinkedList<>();
        bfsQ.add(root);

        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        while (!bfsQ.isEmpty()) {
            int size = bfsQ.size();
            long levelSum = 0;
            for (int i=0; i<size; i++) {
                TreeNode currNode = bfsQ.poll();
                levelSum += currNode.val;

                if (null != currNode.left) {
                    bfsQ.add(currNode.left);
                }
                if (null != currNode.right) {
                    bfsQ.add(currNode.right);
                }
            }
            minHeap.add(levelSum);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        if (minHeap.size() < k) {
            return -1;
        }
        return minHeap.poll();
    }
}