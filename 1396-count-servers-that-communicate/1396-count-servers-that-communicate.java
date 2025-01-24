class Solution {
    public int countServers(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        int[] row_count = new int[ROWS];
        int[] col_count = new int[COLS];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    row_count[r]++;
                    col_count[c]++;
                }
            }
        }

        int res = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1 && (row_count[r] > 1 || col_count[c] > 1)) {
                    res++;
                }
            }
        }
        return res;
    }
}