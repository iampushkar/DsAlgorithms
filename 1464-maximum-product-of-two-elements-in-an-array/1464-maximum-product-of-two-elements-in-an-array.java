class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        
        int first = nums[N-1] - 1;
        int second = nums[N-2] - 1;
        
        return first * second;
    }
}