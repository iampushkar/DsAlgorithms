class Solution {
    public int partitionArray(int[] nums, int k) {
        if(nums.length == 1) return 1;
        
        Arrays.sort(nums);
        int ans = 1;
        int prev = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            if(nums[i] - prev > k) {
                ans++;
                prev = nums[i];
            }
        }
        
        return ans;
    }
}