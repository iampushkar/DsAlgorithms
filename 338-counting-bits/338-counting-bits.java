class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        
        for(int i=0; i<=n; i++) {
            ans[i] = getCountBits(i);
        }
        return ans;
    }
    
    private static int getCountBits(int N) {
        int count = 0;
        while(N > 0)  {
            if((N & 1) == 1) {
                count++;
            }
            N = N >> 1;
        }
        return count;
    }
}