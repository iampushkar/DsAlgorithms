class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int N = triangle.size();

        int[][] dp = new int[N][N];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, triangle, dp);
    }

    private int solve(int row, int col, List<List<Integer>>triangle, int[][] dp) {
        if (row == triangle.size()-1) return triangle.get(row).get(col);
        
        if (dp[row][col] != -1) return dp[row][col];

        int down = triangle.get(row).get(col) + solve(row + 1, col, triangle, dp);
        int diagonal = triangle.get(row).get(col) + solve(row + 1, col + 1, triangle, dp);
        
        return dp[row][col] = Math.min(down, diagonal);
    }
}