class Solution {
    public boolean canPartition(int[] nums) {
        int N = nums.length;
        int targetSum = 0;
        for (int i = 0; i < N; i++) {
            targetSum += nums[i];
        }

        if (targetSum % 2 == 1) {
            return false;
        }

        int K = targetSum / 2;

        int[][] dp = new int[N][K + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return memo(N - 1, K, nums, dp);
    }

    private boolean memo(int ind, int target, int[] nums, int[][] dp) {
        if (target == 0) return true;
        if (ind == 0) return nums[0] == target;

        if (dp[ind][target] != -1) {
            return dp[ind][target] == 0 ? false : true;
        }

        boolean notTake = memo(ind - 1, target, nums, dp);
        boolean take = false;
        if (nums[ind] <= target) {
            take = memo(ind - 1, target - nums[ind], nums, dp);
        }

        dp[ind][target] = notTake || take ? 1 : 0;
        return take || notTake;
    }
}