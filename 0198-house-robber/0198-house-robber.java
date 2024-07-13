class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        return solve(N-1, nums, dp);
    }

    private int solve(int i, int[] nums, int[] dp) {
        if (i == 0) return nums[i]; // have picked i = 0
        if (i < 0) return 0; // havent picked i = 0

        if (dp[i] != -1) return dp[i];

        int pick = nums[i] + solve(i-2, nums, dp);
        int notPick = 0 + solve(i-1, nums, dp);

        return dp[i] = Math.max(pick, notPick);
    }
}