class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        helper(nums, 0, ans);
        
        return ans;
    }
    
    private void helper(int[] nums, int pos,
                        List<List<Integer>> ans) {
        
        if(pos == nums.length) { 
            List<Integer> temp = new ArrayList<>();
            for(int n : nums) { temp.add(n); }
            ans.add(new ArrayList<Integer>(temp));
        }
        
        for(int i=pos; i<nums.length; i++) {
            swap(nums, i, pos);
            helper(nums, pos+1, ans);
            swap(nums, i, pos);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}