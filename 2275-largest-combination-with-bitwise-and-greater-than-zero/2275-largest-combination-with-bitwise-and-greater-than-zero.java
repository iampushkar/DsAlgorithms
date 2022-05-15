class Solution {
    public int largestCombination(int[] candidates) {
        int max = 0, ans = 0;
        for(int i=31; i>=0; i--) {
            int count = 0;
            for(int val : candidates) {
                if(((val >> i) & 1) == 1) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}