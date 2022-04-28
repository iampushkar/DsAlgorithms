class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            list.add(nums[i]);
        }
        backtracking(list, 0);
        return ans;
    }
    
    private void backtracking(List<Integer> nums, int pos) {
        if(pos == nums.size()) {
            ans.add(new ArrayList<>(nums));
        }
        
        for(int i=pos; i<nums.size(); i++) {
            Collections.swap(nums, i, pos);
            backtracking(nums, pos+1);
            Collections.swap(nums, i, pos);
        }
    }
}