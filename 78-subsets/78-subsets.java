class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> currList = new ArrayList<>();
        helper(nums, 0, currList, ans);
        return ans;
    }
    
    private void helper(int[] nums, int pos, List<Integer> currList,
                        List<List<Integer>> ans) {
        
        if(pos == nums.length) {
            ans.add(new ArrayList<Integer>(currList));
            return;
        }
        
        //pick it
        currList.add(nums[pos]);
        helper(nums, pos+1, currList, ans);
        
        //remove it
        currList.remove(currList.size()-1);
        helper(nums, pos+1, currList, ans);
        
    }
}