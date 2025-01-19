class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] dp = new int[rows][cols];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(rows-1, cols-1, obstacleGrid, dp);

    }

    private int solve(int row, int col, int[][] grid, int[][] dp) {
        // base case
        if (row == 0 && col == 0) return grid[0][0] == 1 ? 0 : 1;
        if (row < 0 || col < 0) return 0;
        if (row >= 0 && col >= 0 && grid[row][col] == 1) return 0;

        if (dp[row][col] != -1) return dp[row][col];

        int up = solve(row-1, col, grid, dp);
        int left = solve(row, col-1, grid, dp);

        return dp[row][col] = up + left;
    }
}