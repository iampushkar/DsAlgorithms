class Solution {
    int ans = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int[] count = new int[k];
        
        backtrack(cookies, k, 0, count);
        return ans;
    }
    
    private void backtrack(int[] cookies, int k, int pos, int[] count) {
        if(pos == cookies.length) {
            int max = Integer.MIN_VALUE;
            for(int c : count) {
                max = Math.max(max, c);
            }
            ans = Math.min(ans, max);
            return;
        }
        
        for(int i=0; i<count.length; i++) {
            count[i] += cookies[pos];
            backtrack(cookies, k, pos+1, count);
            count[i] -= cookies[pos];
        }
    }
}