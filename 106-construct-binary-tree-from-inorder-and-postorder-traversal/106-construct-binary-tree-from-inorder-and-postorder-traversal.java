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
    
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        populateMap(inorder, map);

        int is = 0, ie = inorder.length-1; //inorder start and end
        int ps = 0, pe = postorder.length-1; //postorder start and end

        return create(inorder, is, ie, postorder, ps, pe);
    }
    
    private TreeNode create(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if(ps > pe) return null;

        int rootVal = postorder[pe];
        TreeNode root = new TreeNode(rootVal);
        int indexRoot = map.get(rootVal); //search inorder value map
        int numLeft = indexRoot - is;

        root.left = create(inorder, is, indexRoot-1, postorder, ps, ps+numLeft-1);
        root.right = create(inorder, indexRoot+1, ie, postorder, ps+numLeft, pe-1);

        return root;
    }

    private void populateMap(int[] inorder, HashMap<Integer, Integer> map) {
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
    }
}