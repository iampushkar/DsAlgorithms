class Solution {
    public int largestCombination(int[] candidates) {
        int max = 0, ans = 0;
        for(int i=31; i>=0; i--) {
            int count = 0;
            
            for(int val : candidates) {
                if(checkBit(val, i)) { count++; }
            }
            max = Math.max(max, count);
        }
        return max;
    }
    
    private boolean checkBit(int val, int i) {
        return ((val >> i) & 1) == 1;
    }
}