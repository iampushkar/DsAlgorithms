class Solution {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int prev = nums[i-1];
            int curr = nums[i];
            if (
                    (prev % 2 == 0 && curr % 2 == 0) || 
                    (prev % 2 == 1 && curr % 2 == 1)
                ) {
                return false;
            }
        }
        return true;
    }
}