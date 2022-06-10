class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        
        Arrays.sort(nums);
        List<Integer> currList = new ArrayList<>();
        helper(nums, 0, currList, set);
        
        //form ans
        for(List<Integer> list : set) {
            ans.add(list);
        }
        return ans;
    }
    
    private void helper(int[] nums, int pos, List<Integer> currList,
                        Set<List<Integer>> set) {
        
        if(pos == nums.length) {
            set.add(new ArrayList<Integer>(currList));
            return;
        }
        
        //pick it
        currList.add(nums[pos]);
        helper(nums, pos+1, currList, set);
        
        //remove it
        currList.remove(currList.size()-1);
        helper(nums, pos+1, currList, set);
        
    }
}