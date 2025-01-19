class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(grid, rows-1, cols-1, dp);
    }

    private int solve(int[][] grid, int row, int col, int[][] dp) {
        // base case
        if (row == 0 && col == 0) return grid[0][0];
        if (row < 0 || col < 0) return Integer.MAX_VALUE - 10000;

        if (dp[row][col] != -1) return dp[row][col];

        int up = grid[row][col] + solve(grid, row-1, col, dp);
        int left = grid[row][col] + solve(grid, row, col-1, dp);

        return dp[row][col] = Math.min(up, left);
    }
}