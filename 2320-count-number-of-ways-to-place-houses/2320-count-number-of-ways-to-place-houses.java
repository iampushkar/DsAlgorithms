class Solution {
    public int countHousePlacements(int n) {
        long[] dp = new long[n+1];
        long mod = 1000000007;
        
        dp[0] = 1; dp[1] = 2;
        for(int i=2; i<=n; i++) {
            dp[i] = (dp[i-1] % mod + dp[i-2] % mod) % mod;
        }
        
        
        long ans = ( (dp[n] % mod) * (dp[n] % mod) ) % mod;
        
        
        if(ans < 0) {
            ans = (ans + mod) % mod;
        }
        
        return (int)(ans % mod);
    }
}