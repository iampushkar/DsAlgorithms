class Solution {
    public int coinChange(int[] coins, int amount) {
        int N = coins.length;
        int [][] dp = new int[N][amount+1];

        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(dp, N-1, coins, amount);
        return (ans == (int) Math.pow(10, 9)) ? -1 : ans;
    }

    private int solve(int[][] dp, int ind, int[] coins, int amount) {
        if (ind == 0) {
            if (amount % coins[ind] == 0) {
                return amount / coins[ind];
            } else {
                return (int) Math.pow(10, 9);
            }
        }

        if (dp[ind][amount] != -1) return dp[ind][amount];

        int notTake = 0 + solve(dp, ind-1, coins, amount);
        int take = (int) Math.pow(10, 9);
        if (coins[ind] <= amount) {
            take = 1 + solve(dp, ind, coins, amount-coins[ind]);
        }

        return dp[ind][amount] = Math.min(notTake, take);
    }
}