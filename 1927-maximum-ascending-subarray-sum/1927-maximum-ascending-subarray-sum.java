class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxi = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) { 
            if (nums[i] > nums[i-1]) { 
                sum += nums[i]; 
            } else {
                sum = nums[i]; // 5
            }
            maxi = Math.max(maxi, sum);
        }
        return maxi;
    }
}