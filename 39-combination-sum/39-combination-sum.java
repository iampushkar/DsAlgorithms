class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        
        helper(candidates, target, 0, currList, ans);
        return ans;
    }
    
    private void helper(int[] nums, int target, int pos, List<Integer> currList, 
                        List<List<Integer>> ans) {
        
        if(pos == nums.length) {
            if(target == 0) {
                ans.add(new ArrayList<Integer>(currList));
            }
            return;
        }
        
        if(nums[pos] <= target) { //pick it
            currList.add(nums[pos]);
            //stay at same position as we may pick it next time
            helper(nums, target-nums[pos], pos, currList, ans); 
            currList.remove(currList.size()-1);
        }
        //dont pick it and move to next position
        helper(nums, target, pos+1, currList, ans); 
    }
}