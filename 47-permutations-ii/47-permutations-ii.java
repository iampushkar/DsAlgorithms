class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        
        helper(nums, 0, set);
        
        for(List<Integer> list : set) {
            ans.add(list);
        }
        return ans;
    }
    
    private void helper(int[] nums, int pos, HashSet<List<Integer>> set) {
        if(pos == nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int n : nums) { list.add(n); }
            set.add(new ArrayList<Integer>(list));
        }
        
        for(int i=pos; i<nums.length; i++) {
            swap(nums, i, pos);
            helper(nums, pos+1, set);
            swap(nums, i, pos);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}