class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0) { return ans; }
        
        backtrack(0, new ArrayList<Integer>(), nums);
        return ans;
    }
    
    private void backtrack(int pos, ArrayList<Integer> curr, int[] nums) {
        ans.add(new ArrayList<Integer>(curr));
        
        for(int i=pos; i<nums.length; i++) {
            curr.add(nums[i]);
            backtrack(i+1, curr, nums);
            curr.remove(curr.size()-1);
        }
    }
}