/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        Map<Integer, List<Integer>> map1 = buildMap(root1);
        System.out.println("map1 - " + map1);

        Map<Integer, List<Integer>> map2 = buildMap(root2);
        System.out.println("map2 - " + map2);

        return compareMap(map1, map2);
    }

    private boolean compareMap(Map<Integer, List<Integer>> map1, Map<Integer, List<Integer>> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }

        for (int val = 0; val<=99; val++) {
            if ((map1.containsKey(val) && !map2.containsKey(val)) || 
                    (!map1.containsKey(val) && map2.containsKey(val))) {
                return false;
            }
            if (map1.containsKey(val) && map2.containsKey(val)) {
                List<Integer> list1 = map1.get(val);
                Collections.sort(list1);

                List<Integer> list2 = map2.get(val);
                Collections.sort(list2);

                if (!list1.equals(list2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private Map<Integer, List<Integer>> buildMap(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        if (root == null) {
            return map;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        // List<Integer> list =  new ArrayList<>();
        // list.add(root.val);
        // map.put(root.val, list);

        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                List<Integer> currLevelList = new ArrayList<>();
                if (null != curr && null != curr.left) {
                    q.add(curr.left);
                    currLevelList.add(curr.left.val);
                }
                if (null != curr && null != curr.right) {
                    q.add(curr.right);
                    currLevelList.add(curr.right.val);
                }
                map.put(curr.val, currLevelList);
                System.out.println(i + " - " + map);
            }
            
        }
        return map;
    }
}

// map1 - {0=[3, 1], 1=[2], 2=[], 3=[2]}
// map2 - {0=[3, 1], 1=[2], 2=[], 3=[2]}