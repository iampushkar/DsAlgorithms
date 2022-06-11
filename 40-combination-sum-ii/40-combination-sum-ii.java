class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        
        Arrays.sort(candidates);
        
        helper(candidates, target, 0, currList, ans);
        
        return ans;
    }
    
    private void helper(int[] nums, int target, int pos, List<Integer> currList, 
                        List<List<Integer>> ans) {
        
        if(target < 0) return;
        else if(target == 0) ans.add(new ArrayList<Integer>(currList));
        else {
            for(int i=pos; i<nums.length; i++) {
                if(i > pos && nums[i] == nums[i-1]) continue;
                
                currList.add(nums[i]);
                helper(nums, target-nums[i], i+1, currList, ans);
                currList.remove(currList.size()-1);
            }
        }
        
    }
}