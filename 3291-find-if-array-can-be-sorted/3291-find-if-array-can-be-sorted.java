class Solution {
    public boolean canSortArray(int[] nums) {
        int currMin = nums[0];
        int currMax = nums[0];
        int prevMax = Integer.MIN_VALUE;

        for (int n : nums) {
            if (Integer.bitCount(n) == Integer.bitCount(currMin)) {
                currMin = Math.min(n, currMin);
                currMax = Math.max(n, currMax);
            } else {
                if (currMin < prevMax) {
                    return false;
                }
                prevMax = currMax;
                currMin = n;
                currMax = n;
            }
        }
        if (currMin < prevMax) {
            return false;
        }
        return true;
    }
}