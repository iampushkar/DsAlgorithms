class Solution {
    public int equalPairs(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        
        Map<String, Integer> rowFreqMap = new HashMap<>();
        int res = 0;

        for (int r = 0; r < ROWS; r++) {
            StringBuilder rowStr = new StringBuilder();
            for (int c = 0; c < COLS; c++) {
                rowStr.append(grid[r][c]).append('#');
            }
            String rowKey = rowStr.toString();
            rowFreqMap.put(
                rowKey, 
                rowFreqMap.getOrDefault(rowKey, 0) + 1
                );
        }

        for (int c = 0; c < COLS; c++) {
            StringBuilder colStr = new StringBuilder();
            for (int r = 0; r < ROWS; r++) {
                colStr.append(grid[r][c]).append('#');
            }
            String colKey = colStr.toString();
            if (rowFreqMap.containsKey(colKey)) {
                res += rowFreqMap.get(colKey);
            }
        }

        return res;
    }
}