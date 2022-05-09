class Solution {
    public int numDecodings(String s) {
        int N = s.length();
        char[] ch = s.toCharArray();
        
        if(s.isEmpty() || ch[0] == '0') return 0;
        
        int[] dp = new int[N+1];
        dp[0] = 1; dp[1] = 1;
        
        for(int i=2; i<=N; i++) {
            //single char considered
            if(ch[i-1] >= '1' && ch[i-1] <= '9') {
                dp[i] += dp[i-1];
            }
            
            //double char considered
            if(ch[i-2] == '1') {
                dp[i] += dp[i-2];
            } else if(ch[i-2] == '2' && ch[i-1] >= '0' && ch[i-1] <= '6') {
                dp[i] += dp[i-2];
            }
        }
        
        return dp[N];
    }
}