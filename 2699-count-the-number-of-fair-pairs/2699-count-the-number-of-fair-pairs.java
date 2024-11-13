class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long res = 0;

        for (int i=0; i<nums.length-1; i++) {
            int low = lower - nums[i];
            int up = upper - nums[i];

            res += (
                binarySearch(nums, i+1, nums.length-1, up+1) - 
                binarySearch(nums, i+1, nums.length-1, low)
            );
        }

        return res;
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + ((r-l) / 2);

            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}