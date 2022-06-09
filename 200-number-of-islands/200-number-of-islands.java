class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        int count = 0;
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                int val = grid[i][j];
                if(val == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(char[][] grid, int row, int col) {
        if(row < 0 || col < 0 || 
           row >= grid.length || col >= grid[0].length || 
           grid[row][col] == '0') {
            return;
        }
        
        grid[row][col] = '0';
        
        dfs(grid, row-1, col); //up
        dfs(grid, row+1, col); //down
        dfs(grid, row, col-1); //left
        dfs(grid, row, col+1); //right
        
    }
}