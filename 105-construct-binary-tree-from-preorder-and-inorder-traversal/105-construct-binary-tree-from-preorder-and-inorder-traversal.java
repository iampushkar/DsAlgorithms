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
    HashMap<Integer, Integer> map ;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int ps = 0, pe = preorder.length-1;
        int is = 0, ie = inorder.length-1;
        map = new HashMap<>();
        populateMap(map, inorder);

        return create(preorder, ps, pe, inorder, is, ie);
    }

    private TreeNode create(int[] preorder,int ps,int pe,int[] inorder,int is,int ie) {
        if(ps > pe) return null;

        int firstRoot = preorder[ps];
        TreeNode root = new TreeNode(firstRoot);
        int indexRoot = map.get(firstRoot);

        int numLst = indexRoot - is;
        root.left = create(preorder, ps+1, ps+numLst, inorder, is, indexRoot-1);
        root.right = create(preorder, ps+numLst+1, pe, inorder, indexRoot+1, ie);

        return root;
    }

    private void populateMap(HashMap<Integer, Integer> map, int[] inorder) {
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
    }
}